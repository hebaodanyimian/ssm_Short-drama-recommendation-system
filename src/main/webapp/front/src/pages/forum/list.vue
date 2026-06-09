<template>
	<div class="forum-preview">
		<div class="forum-title">
			<div>互动论坛</div>
		</div>
		<el-form :inline="true" :model="formSearch" class="list-form-pv">
			<el-form-item class="search-item">
				<el-input v-model="title" placeholder="标题"></el-input>
			</el-form-item>
			<div class="search-btn-item">
				<el-button class="searchBtn" type="primary" @click="getForumList(1)">
					<span class="icon iconfont icon-shouye-zhihui"></span>
					查询
				</el-button>
				<el-button class="pubBtn" type="primary" @click="toForumAdd">
					<span class="icon iconfont icon-shouye-zhihui"></span>
					发布帖子
				</el-button>
			</div>
		</el-form>
		<div class="category-list">
			<div class="item" @click="categoryClick(0)" :class="categoryIndex == 0 ? 'active' : ''">全部</div>
			<div v-for="(item,index) in categoryList" @click="categoryClick(index+1)" :key="index" class="item" :class="categoryIndex == index+1 ? 'active' : ''">{{item.typename}}</div>
		</div>
		<div class="z-box">
			<div class="section-content" v-for="item in forumList" :key="item.id" @click.stop="toForumDetail(item)">
				<img class="item-img" :src="$config.baseUrl + item.cover.split(',')[0]" @click.stop="imgPreView($config.baseUrl + item.cover.split(',')[0])" />
				<div class="item-title">{{item.title}}</div>
				<div class="item-user">发布人：{{item.isanon==1&&item.userid!=userid?'匿名':item.username}}</div>
				<div class="item-time">{{item.addtime}}</div>
			</div>
		</div>
		<el-pagination
			background
			id="pagination" class="pagination"
			:pager-count="7"
			:page-size="pageSize"
			:page-sizes="pageSizes"
			prev-text="<"
			next-text=">"
			:hide-on-single-page="true"
			:layout='["total","prev","pager","next","sizes","jumper"].join()'
			:total="total"
			@current-change="curChange"
			@prev-click="prevClick"
			@next-click="nextClick"
			></el-pagination>
		<el-dialog title="预览图" :visible.sync="previewVisible" width="50%">
			<img :src="previewImg" alt="" style="width: 100%;">
		</el-dialog>
	</div>
</template>

<script>
	export default {
		//数据集合
		data() {
			return {
				formSearch: {},
				title: '',
				layouts: '',
				forumList: [],
				total: 1,
				pageSize: 10,
				pageSizes: [],
				totalPage: 1,
				previewImg: '',
				previewVisible: false,
				userid: localStorage.getItem('frontUserid'),
				categoryIndex: 0,
				categoryList: [],
			}
		},
		created() {
			this.getCategoryList()
		},
		watch:{
			$route(newValue){
				this.getCategoryList()
			}
		},
		//方法集合
		methods: {
			getCategoryList(){
				this.$http.get('forumtype/list', {}).then(res => {
					if (res.data.code == 0) {
						this.categoryList = res.data.data.list
						if(this.$route.query.homeFenlei){
							for(let i=0;i<this.categoryList.length;i++) {
								if(this.$route.query.homeFenlei == this.categoryList[i].typename) {
									this.categoryIndex = i + 1;
									const currentRoute = this.$route;
									const routeWithoutQuery = { ...currentRoute };
									delete routeWithoutQuery.query;
									this.$router.replace(routeWithoutQuery)
									break;
								}
							}
						}
						this.getForumList(1);
					}
				});
			},
			categoryClick(index) {
				this.categoryIndex = index
				this.getForumList()
			},
			imgPreView(url){
				this.previewImg = url
				this.previewVisible = true
			},
			getForumList(page) {
				let params = {page, limit: this.pageSize, isdone: '开放', sort: 'istop,toptime', order: 'desc,desc',delflag: 0};
				let searchWhere = {};
				if(this.title != '') searchWhere.title = '%' + this.title + '%';
				if(this.categoryIndex!=0){
					searchWhere.typename = this.categoryList[this.categoryIndex - 1].typename
				}
				this.$http.get('forum/flist', {params: Object.assign(params, searchWhere)}).then(res => {
					if (res.data.code == 0) {
						this.forumList = res.data.data.list;
						this.total = res.data.data.total;
						this.pageSize = Number(res.data.data.pageSize);
						this.totalPage = res.data.data.totalPage;
						if(this.pageSizes.length==0){
							this.pageSizes = [this.pageSize, this.pageSize*2, this.pageSize*3, this.pageSize*5];
						}
					}
				});
			},
			curChange(page) {
				this.getForumList(page);
			},
			prevClick(page) {
				this.getForumList(page);
			},
			nextClick(page) {
				this.getForumList(page);
			},
			toForumAdd() {
				this.$router.push('/index/forumAdd');
			},
			toForumDetail(item) {
				this.$router.push({path: '/index/forumDetail', query: {id: item.id}});
			}
		}
	}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.forum-preview {
				padding: 20px;
				margin: 20px auto;
				max-width: 1200px;
				background: none;
				width: 100%;
				position: relative;
				.forum-title {
						padding: 0;
						margin: 0;
						color: #000;
						background: none;
						font-weight: 600;
						letter-spacing: 2px;
						width: 100%;
						font-size: 22px;
						line-height: 50px;
						text-align: center;
						div {
								padding: 0;
								color: inherit;
								font-weight: 600;
								display: inline-block;
								font-size: 24px;
								border-color: #37A679;
								border-width: 0 0 2px 0;
								border-style: solid;
							}
		}
		.list-form-pv {
						padding: 10px 0;
						margin: 10px 0;
						background: none;
						display: flex;
						width: 100%;
						align-items: center;
						flex-wrap: wrap;
						height: auto;
						.search-item {
								margin: 0 10px 0 0;
								/deep/ .el-form-item__content {
										display: flex;
										align-items: center;
									}
				.el-input {
										width: 100%;
									}
				.el-input /deep/ .el-input__inner {
										border: 1px solid #000;
										border-radius: 4px;
										padding: 0 10px;
										margin: 0;
										outline: none;
										color: #333;
										width: 280px;
										font-size: 14px;
										line-height: 42px;
										height: 42px;
									}
			}
			.search-btn-item {
								display: flex;
								.searchBtn {
										cursor: pointer;
										border: 0;
										border-radius: 4px;
										padding: 0px 15px;
										margin: 0 10px 0 0;
										outline: none;
										background: #F7BA02;
										width: auto;
										font-size: 14px;
										line-height: 42px;
										height: 42px;
										.icon {
												margin: 0 10px 0 0;
												color: #fff;
											}
				}
				
				.searchBtn:hover {
										background: rgba(64, 158, 255, .5);
									}
				
				.pubBtn {
										cursor: pointer;
										border: 0;
										border-radius: 4px;
										padding: 0px 15px;
										margin: 0 10px 0 0;
										outline: none;
										color: #fff;
										background: #37A679;
										width: auto;
										font-size: 14px;
										line-height: 42px;
										height: 42px;
										.icon {
												margin: 0 10px 0 0;
												color: #fff;
												font-size: 14px;
											}
				}
				
				.pubBtn:hover {
										background: rgba(64, 158, 255, .5);
									}
			}
		}
		.category-list {
						border: 1px solid #000;
						border-radius: 0;
						padding: 10px;
						background: none;
						display: flex;
						width: 100%;
						height: auto;
						.item {
								cursor: pointer;
								border-radius: 0;
								padding: 0 20px;
								margin: 0 10px 0 0;
								color: #fff;
								background: #F7BA02;
								width: auto;
								font-size: 14px;
								line-height: 36px;
								text-align: center;
							}
			
			.item:hover {
								color: #fff;
								background: #37A679;
							}
			
			.item.active {
								color: #fff;
								background: #37A679;
							}
		}
		.z-box {
						border: none;
						padding: 0;
						margin: 20px 0 0;
						background: #fff;
						width: 100%;
						.section-content {
								cursor: pointer;
								border-radius: 10px;
								padding: 10px 0;
								margin: 0 0 10px 0;
								background: none;
								display: flex;
								width: 100%;
								border-color: #000;
								border-width: 1px;
								align-items: center;
								border-style: solid;
								flex-wrap: wrap;
								.item-img {
										border-radius: 50%;
										margin: 0 10px 0 40px;
										width: 60px;
										transition: all .4s;
										height: 60px;
										order: 2;
									}
				.item-title {
										padding: 0 40px 4px;
										margin: 0 0 6px 0;
										color: #666;
										flex: auto;
										width: 100%;
										font-size: 14px;
										border-color: #000000;
										border-width: 0 0 1px 0;
										line-height: 24px;
										border-style: solid;
										order: 1;
									}
				.item-user {
										color: #666;
										flex: 1;
										font-size: 14px;
										order: 3;
									}
				.item-time {
										color: #666;
										flex: 1;
										font-size: 14px;
										order: 4;
									}
			}
			.section-content:hover {
								background: #e4e7ed;
								.item-title {
										color: #111;
									}
				.item-user {
										color: #111;
									}
				.item-time {
										color: #111;
									}
			}
		}
	}
</style>
