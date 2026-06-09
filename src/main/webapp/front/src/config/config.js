export default {
	baseUrl: 'http://localhost:8080/ssmc0ql52z2/',
	name: '/ssmc0ql52z2',
	indexNav: [
		{
			name: '短剧信息',
			url: '/index/duanjuxinxi',
		},
		{
			name: '互动论坛',
			url: '/index/forum'
		}, 
		{
			name: '短剧资讯',
			url: '/index/news'
		},
	],
	cateList: [
		{
			name: '短剧信息',
			refTable: 'duanjufenlei',
			refColumn: 'duanjufenlei',
		},
		{
			name: '互动论坛',
			refTable: 'forumtype',
			refColumn: 'typename',
		},
		{
			name: '短剧资讯',
			refTable: 'newstype',
			refColumn: 'typename',
		},
	]
}
