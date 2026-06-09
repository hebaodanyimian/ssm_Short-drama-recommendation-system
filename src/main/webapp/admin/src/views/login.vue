<template>
	<div>
		<div class="login-container">
			<el-form class="login_form animate__animated animate__backInDown">
				<div class="login_form2">
					<div class="title-container">基于java的短剧推荐系统设计与实现</div>
					<div v-if="loginType==1" class="list-item">
						<div class="lable">
							账号：
						</div>
						<input placeholder="请输入账号：" name="username" type="text" v-model="rulesForm.username">
					</div>
					<div v-if="loginType==1" class="list-item">
						<div class="lable">
							密码：
						</div>
						<div class="password-box">
							<input placeholder="请输入密码：" name="password" :type="showPassword?'text':'password'" v-model="rulesForm.password">
							<span class="icon iconfont" :class="showPassword?'icon-liulan13':'icon-liulan17'" @click="showPassword=!showPassword"></span>
						</div>
					</div>

					<div class="list-item " v-if="roles.length>1">
						<div class="lable">
							角色：
						</div>
						<div prop="loginInRole" class="list-type">
							<el-radio v-if="loginType==1||(loginType==2&&item.roleName!='管理员')" v-for="item in roles" v-bind:key="item.roleName" v-model="rulesForm.role" :label="item.roleName">{{item.roleName}}</el-radio>
						</div>
					</div>

		
					<div class="login-btn">
						<div class="login-btn1">
							<el-button v-if="loginType==1" type="primary" @click="login()" class="loginInBt">登录</el-button>
						</div>
						<div class="login-btn2">
						</div>
						<div class="login-btn3">
						</div>
					</div>
				</div>
				<div class="idea-box2"></div>
			</el-form>
		</div>
	</div>
</template>
<script>
	import 'animate.css'
	import menu from "@/utils/menu";
	export default {
		data() {
			return {
				verifyCheck2: false,
				flag: false,
				baseUrl:this.$base.url,
				loginType: 1,
				rulesForm: {
					username: "",
					password: "",
					role: "",
				},
				menus: [],
				roles: [],
				tableName: "",
				showPassword: false,
			};
		},
		mounted() {
			let menus = menu.list();
			this.menus = menus;

			for (let i = 0; i < this.menus.length; i++) {
				if (this.menus[i].hasBackLogin=='是') {
					this.roles.push(this.menus[i])
				}
			}

		},
		created() {

		},
		destroyed() {
		},
		components: {
		},
		methods: {

			//注册
			register(tableName){
				this.$storage.set("loginTable", tableName);
				this.$router.push({path:'/register',query:{pageFlag:'register'}})
			},
			// 登陆
			login() {

				if (!this.rulesForm.username) {
					this.$message.error("请输入用户名");
					return;
				}
				if (!this.rulesForm.password) {
					this.$message.error("请输入密码");
					return;
				}
				if(this.roles.length>1) {
					if (!this.rulesForm.role) {
						this.$message.error("请选择角色");
						return;
					}

					let menus = this.menus;
					for (let i = 0; i < menus.length; i++) {
						if (menus[i].roleName == this.rulesForm.role) {
							this.tableName = menus[i].tableName;
						}
					}
				} else {
					this.tableName = this.roles[0].tableName;
					this.rulesForm.role = this.roles[0].roleName;
				}
		
				this.loginPost()
			},
			loginPost() {
				this.$http({
					url: `${this.tableName}/login?username=${this.rulesForm.username}&password=${this.rulesForm.password}`,
					method: "post"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.$storage.set("Token", data.token);
						this.$storage.set("role", this.rulesForm.role);
						this.$storage.set("sessionTable", this.tableName);
						this.$storage.set("adminName", this.rulesForm.username);
						this.$router.replace({ path: "/" });
					} else {
						this.$message.error(data.msg);
					}
				});
			},
		}
	}
</script>

<style lang="scss" scoped>
.login-container {
	min-height: 100vh;
	position: relative;
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	background: url(http://codegen.caihongy.cn/20241017/b542a97f8c98453b9dab5714a95e3df8.webp);
	background-repeat: no-repeat;
	background-size: cover;
	background: url(http://codegen.caihongy.cn/20241017/b542a97f8c98453b9dab5714a95e3df8.webp);
	display: flex;
	width: 100%;
	min-height: 100vh;
	justify-content: flex-end;
	align-items: center;
	background-position: center center;

	.login_form {
		border-radius: 0;
		padding: 0;
		margin: 0 250px 0 0;
		z-index: 1000;
		flex-direction: column;
		background: transparent;
		display: flex;
		width: 520px;
		align-items: flex-end;
		position: relative;
		height: auto;
		.login_form2 {
			width: 100%;
		}
		.title-container {
			padding: 0;
			margin: 0 0px;
			color: #333;
			background: none;
			font-weight: 600;
			width: 100%;
			font-size: 18px;
			line-height: 40px;
			text-align: center;
		}
		.list-item {
			padding: 0;
			margin: 0 0 20px;
			display: flex;
			width: 100%;
			border-color: #046D66;
			border-width: 0 0 2px 0;
			align-items: center;
			position: relative;
			border-style: solid;
			.lable {
				color: #046D66;
				flex: 0 0 auto;
				width: 100px;
				font-size: 14px;
				line-height: 40px;
				text-align: right;
			}
			input {
				border: 0px solid #efeff7;
				background-color: transparent;
				border-radius: 4px;
				padding: 0 10px;
				outline: none;
				color: #000;
				flex: 1 1 auto;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
			input:focus {
				border: 0px solid #efeff7;
				background-color: transparent;
				border-radius: 4px;
				padding: 0 10px;
				color: #000;
				flex: 1 1 auto;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
			.password-box {
				display: flex;
				width: 100%;
				position: relative;
				align-items: center;
				input {
					border: 0px solid #efeff7;
					background-color: transparent;
					border-radius: 4px;
					padding: 0 10px;
					outline: none;
					color: #000;
					flex: 1 1 auto;
					width: auto;
					font-size: 14px;
					height: 40px;
				}
				input:focus {
					border: 0px solid #efeff7;
					background-color: transparent;
					border-radius: 4px;
					padding: 0 10px;
					color: #000;
					flex: 1 1 auto;
					width: auto;
					font-size: 14px;
					height: 40px;
				}
				.iconfont {
					cursor: pointer;
					z-index: 1;
					color: #000;
					top: 0;
					font-size: 16px;
					line-height: 44px;
					position: absolute;
					right: 5px;
				}
			}
			input::placeholder {
				color: #9E9E9E;
				font-size: 16px;
			}
		}
		.list-type {
			padding: 0;
			margin: 0;
			background: none;
			width: calc(100% - 0px);
			line-height: 40px;
			height: auto;
			/deep/ .el-radio__input .el-radio__inner {
				background: rgba(53, 53, 53, 0);
				border-color: #666;
			}
			/deep/ .el-radio__input.is-checked .el-radio__inner {
				background: #0d6efd;
				border-color: #0d6efd;
			}
			/deep/ .el-radio__label {
				color: #666;
				font-size: 14px;
			}
			/deep/ .el-radio__input.is-checked+.el-radio__label {
				color: #0d6efd;
				font-size: 14px;
			}
		}
		.login-btn {
			margin: 0 auto;
			display: flex;
			width: 100%;
			justify-content: center;
			align-items: center;
			flex-wrap: wrap;
			.login-btn1 {
				width: 100%;
			}
			.login-btn2 {
				margin: 30px 0 0 0;
				display: flex;
				gap: 20px;
				width: 100%;
				justify-content: center;
				align-items: center;
				flex-wrap: wrap;
			}
			.login-btn3 {
				margin: -10px 0 20px 0;
				width: 100%;
				order: -1;
			}
			.loginInBt {
				border: 0px solid rgba(0, 0, 0, 1);
				cursor: pointer;
				padding: 0 10px;
				margin: 0 0 10px;
				color: #fff;
				font-weight: 600;
				font-size: 24px;
				border-radius: 30px;
				box-shadow: inset 0px -2px 6px 0px rgba(10,37,64,0.35), 0px 30px 60px -30px rgba(0,0,0,0.3), 0px 50px 100px -20px rgba(50,50,93,0.25);
				background: #046D66;
				width: 100%;
				min-width: 68px;
				height: 44px;
			}
			.loginInBt:hover {
				opacity: 0.8;
			}
			.register {
				border: 1px solid #000000;
				cursor: pointer;
				border-radius: 5px;
				padding: 0 20px;
				margin: 0 0 10px;
				color: #000000;
				background: #fff;
				width: auto;
				font-size: 16px;
				height: 34px;
			}
			.register:hover {
				opacity: 0.8;
			}
			.forget {
				border: 0;
				cursor: pointer;
				border-radius: 0;
				padding: 0;
				margin: 0;
				color: #000000;
				background: none;
				width: 100%;
				font-size: 16px;
				text-align: right;
				height: 34px;
			}
			.forget:hover {
				color: #0d6efd;
				opacity: 1;
			}
		}
	}
	.idea-box2 {
		background: url(http://codegen.caihongy.cn/20241017/8b27ac6340284b01af8a8e0f506760a6.webp) center no-repeat;
		width: 100%;
		height: 140px;
		order: -1;
	}
}

</style>
