<template>
	<div>

		<div class="container">
			<el-form class='rgs-form animate__animated animate__fadeInLeft' v-if="pageFlag=='register'" ref="registerForm" :model="registerForm" :rules="rules">
				<div class="rgs-form2">
					<div class="title">基于java的短剧推荐系统设计与实现注册</p></div>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="yonghuzhanghao">
						<div class="label" :class="changeRules('yonghuzhanghao')?'required':''">用户账号：</div>
						<el-input v-model="registerForm.yonghuzhanghao"  placeholder="请输入用户账号" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="mima">
						<div class="label" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="mima2">
						<div class="label" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="yonghuxingming">
						<div class="label" :class="changeRules('yonghuxingming')?'required':''">用户姓名：</div>
						<el-input v-model="registerForm.yonghuxingming"  placeholder="请输入用户姓名" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="xingbie">
						<div class="label" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in yonghuxingbieOptions"
								:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="touxiang">
						<div class="label" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="1"
							:multiple="true"
							:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
							@change="yonghutouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="lianxifangshi">
						<div class="label" :class="changeRules('lianxifangshi')?'required':''">联系方式：</div>
						<el-input v-model="registerForm.lianxifangshi"  placeholder="请输入联系方式" />
					</el-form-item>
					<div class="register-btn">
						<div class="register-btn1">
							<el-button class="register_btn" type="primary" @click="submitForm('registerForm')">注册</el-button>
						</div>
						<div class="register-btn2">
							<router-link class="has_btn" to="/login">已有账号，直接登录</router-link>
						</div>
					</div>
				</div>
				<div class="idea1"></div>
				<div class="idea2"></div>
			</el-form>
		</div>
	</div>
</div>
</template>

<script>
	import 'animate.css';

export default {
    //数据集合
    data() {
		return {
            pageFlag : '',
			tableName: '',
			registerForm: {},
			forgetForm: {},
			rules: {},
			requiredRules: {},
            yonghuxingbieOptions: [],
		}
    },
	mounted() {
		if(this.$route.query.pageFlag=='register'){
			this.tableName = this.$route.query.role;
			if(this.tableName=='yonghu'){
				this.registerForm = {
					yonghuzhanghao: '',
					mima: '',
					mima2: '',
					yonghuxingming: '',
					xingbie: '',
					touxiang: '',
					lianxifangshi: '',
					sfsh: '',
					shhf: '',
				}
			}
			if ('yonghu' == this.tableName) {
				this.rules.yonghuzhanghao = [{ required: true, message: '请输入用户账号', trigger: 'blur' }];
				this.requiredRules.yonghuzhanghao = [{ required: true, message: '请输入用户账号', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.yonghuxingming = [{ required: true, message: '请输入用户姓名', trigger: 'blur' }];
				this.requiredRules.yonghuxingming = [{ required: true, message: '请输入用户姓名', trigger: 'blur' }]
			}
			this.yonghuxingbieOptions = "男,女".split(',');
			if ('yonghu' == this.tableName) {
				this.rules.lianxifangshi = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
			}
		}
	},
    created() {
		this.pageFlag = this.$route.query.pageFlag;
    },
    //方法集合
    methods: {
		changeRules(name){
			if(this.requiredRules[name]){
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
        // 下二随
		yonghutouxiangUploadChange(fileUrls) {
			this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
		},

		// 多级联动参数


		submitForm(formName) {
			this.$refs[formName].validate((valid) => {
				if (valid) {
					var url=this.tableName+"/register";
					if(this.tableName=='yonghu'){
						this.registerForm.sfsh = '待审核'
					}
					if(`yonghu` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
						this.$message.error(`两次密码输入不一致`);
						return
					}
					this.$http.post(url, this.registerForm).then(res => {
						if (res.data.code === 0) {
							this.$message({
								message: '注册成功',
								type: 'success',
								duration: 1500,
								onClose: () => {
									this.$router.push('/login');
								}
							});
						} else {
							this.$message.error(res.data.msg);
						}
					});
				} else {
					return false;
				}
			});
		},
		resetForm(formName) {
			this.$refs[formName].resetFields();
		}
    }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.container {
		background: url(http://codegen.caihongy.cn/20250220/3f15ecde8ac4402f936608f6a4eff0f8.png) no-repeat center / 100% 100%;
		display: flex;
		width: 100%;
		min-height: 100vh;
		justify-content: flex-start;
		align-items: center;
		position: relative;
		background: url(http://codegen.caihongy.cn/20250220/3f15ecde8ac4402f936608f6a4eff0f8.png) no-repeat center / 100% 100%;
		.rgs-form {
			padding: 0;
			margin: 60px 0;
			display: flex;
			border-color: #C60000;
			min-height: 80vh;
			border-radius: 0;
			box-shadow: none;
			background: none;
			width: 55%;
			justify-content: flex-start;
			border-width: 0;
			align-items: center;
			border-style: solid;
			height: auto;
			.rgs-form2 {
				padding: 60px 0;
				margin: 0 auto;
				flex-direction: column;
				max-width: 800px;
				background: url(http://codegen.caihongy.cn/20250220/fd7d70154b7d4f9d82d5bbe368471242.png) no-repeat center / 100% 100%;
				display: flex;
				width: 80%;
				justify-content: center;
				align-items: center;
				min-width: 500px;
				height: 100%;
				.title {
					margin: 0 auto 30px auto;
					text-shadow: none;
					color: #000000;
					font-weight: 700;
					width: 100%;
					font-size: 22px;
					line-height: 33px;
					text-align: center;
				}
				.subtitle {
					margin: 0 0 10px 0;
					text-shadow: 4px 4px 2px rgba(64, 158, 255, .5);
					color: rgba(64, 158, 255, 1);
					width: 100%;
					font-size: 20px;
					line-height: 44px;
					text-align: center;
				}
				.list-item {
					border-radius: 0;
					padding: 0;
					box-shadow: none;
					margin: 0 auto 30px auto;
					background: #fff;
					display: flex;
					width: 400px;
					border-color: #F7BA02;
					border-width: 0 0 1px 0;
					align-items: center;
					border-style: solid;
					/deep/.el-form-item__content {
						display: flex;
						width: 100%;
						.label {
							border-radius: 2px;
							margin: 0;
							color: #000;
							flex: none;
							background: none;
							width: 100px;
							font-size: 14px;
							line-height: 36px;
							text-align: center;
							height: 36px;
						}
						
						.required {
							position: relative;
						}
						.required::after{
							color: red;
							left: 2px;
							position: absolute;
							content: "*";
						}
						.el-input {
							width: 100%;
						}
						.el-input .el-input__inner {
							border: none;
							padding: 0 10px;
							outline: none;
							color: #000;
							flex: auto;
							background: none;
							width: 100%;
							font-size: 14px;
							height: 44px;
						}
						.el-input .el-input__inner:focus {
							border: none;
							padding: 0 10px;
							outline: none;
							color: #000;
							flex: auto;
							background: none;
							width: 100%;
							font-size: 14px;
							height: 44px;
						}
						.el-input-number {
							width: 100%;
						}
						.el-input-number .el-input__inner {
							text-align: left;
							border: none;
							padding: 0 10px;
							outline: none;
							color: #000;
							flex: auto;
							background: none;
							width: 100%;
							font-size: 14px;
							height: 44px;
						}
						.el-input-number .el-input-number__decrease {
							display: none;
						}
						.el-input-number .el-input-number__increase {
							display: none;
						}
						.el-select {
							width: 100%;
						}
						.el-select .el-input__inner {
							border: none;
							padding: 0 10px;
							outline: none;
							color: #000;
							flex: auto;
							background: none;
							width: 100%;
							font-size: 14px;
							height: 44px;
						}
						.el-select .el-input__inner:focus {
							border: none;
							padding: 0 10px;
							outline: none;
							color: #000;
							flex: auto;
							background: none;
							width: 100%;
							font-size: 14px;
							height: 44px;
						}
						.el-date-editor {
							width: 100%;
						}
						.el-date-editor .el-input__inner {
							border: none;
							padding: 0 10px 0 40px;
							outline: none;
							color: #000;
							flex: auto;
							background: none;
							width: 100%;
							font-size: 14px;
							height: 44px;
						}
						.el-date-editor .el-input__inner:focus {
							border: none;
							padding: 0 10px 0 40px;
							outline: none;
							color: #000;
							flex: auto;
							background: none;
							width: 100%;
							font-size: 14px;
							height: 44px;
						}
						.el-upload--picture-card {
							background: transparent;
							border: 0;
							border-radius: 0;
							width: auto;
							height: auto;
							line-height: initial;
							vertical-align: middle;
						}
						.upload .upload-img {
							border: 1px dashed #000;
							cursor: pointer;
							border-radius: 8px;
							color: rgba(64, 158, 255, 1);
							width: 80px;
							font-size: 32px;
							line-height: 80px;
							text-align: center;
							height: 80px;
						}
						.el-upload-list .el-upload-list__item {
							border: 1px dashed #000;
							cursor: pointer;
							border-radius: 8px;
							color: rgba(64, 158, 255, 1);
							width: 80px;
							font-size: 32px;
							line-height: 80px;
							text-align: center;
							height: 80px;
							font-size: 14px;
							line-height: 1.8;
						}
						.el-upload .el-icon-plus {
							border: 1px dashed #000;
							cursor: pointer;
							border-radius: 8px;
							color: rgba(64, 158, 255, 1);
							width: 80px;
							font-size: 32px;
							line-height: 80px;
							text-align: center;
							height: 80px;
						}
						.el-upload__tip {
							color: #838fa1;
						}
						.emailInput {
							border: none;
							padding: 0 10px;
							outline: none;
							color: #000;
							flex: auto;
							background: none;
							width: 100%;
							font-size: 14px;
							height: 44px;
						}
						.emailInput:focus {
							border: none;
							padding: 0 10px;
							outline: none;
							color: #000;
							flex: auto;
							background: none;
							width: 100%;
							font-size: 14px;
							height: 44px;
						}
						.el-btn {
							border: 0;
							cursor: pointer;
							padding: 0;
							margin: 0;
							color: #fff;
							font-size: 12px;
							border-radius: 0 4px 4px 0;
							box-shadow: none;
							outline: none;
							background: #F7BA02;
							flex: none;
							width: 100px;
							height: 36px;
						}
						.el-btn:hover {
							opacity: 0.7;
						}
						
						.el-input__inner::placeholder {
							color: #CDCDCD;
							font-size: 14px;
						}
						input::placeholder {
							color: #CDCDCD;
							font-size: 14px;
						}
						.editor {
							width: 100%;
							height: auto;
						}
					}
				}
				.register-btn {
					padding: 0 0 20px 0;
					width: 100%;
				}
				.register-btn1 {
					margin: 0 auto;
					width: 400px;
				}
				.register-btn2 {
					margin: 10px auto 0;
					width: 400px;
				}
				.register_btn {
					border: none;
					cursor: pointer;
					padding: 0 30px;
					margin: 0;
					color: #fff;
					font-weight: 600;
					letter-spacing: 2px;
					font-size: 20px;
					border-radius: 4px;
					outline: none;
					background: #37A679;
					width: 100%;
					height: 50px;
				}
				.register_btn:hover {
					opacity: 0.5;
				}
				.has_btn {
					cursor: pointer;
					padding: 0;
					color: #000;
					display: inline-block;
					text-decoration: none;
					font-size: 14px;
					line-height: 1;
				}
				.has_btn:hover {
					opacity: 0.5;
				}
			}
			.idea1 {
				background: red;
				display: none;
				width: 100%;
				height: 40px;
			}
			.idea2 {
				background: blue;
				display: none;
				width: 100%;
				height: 40px;
			}
		}
	}
	
	::-webkit-scrollbar {
		display: none;
	}
</style>
