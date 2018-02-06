
CREATE TABLE `user_auth_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `openid` varchar(100) NOT NULL COMMENT '用户唯一标识',
  `access_token` varchar(500) DEFAULT NULL COMMENT '用户凭证 结合expires_in使用 生效时间为update_time',
  `expires_in` int(11) DEFAULT 0 COMMENT 'access_token接口调用凭证超时时间，单位（秒）',
	`refresh_token` varchar(20) DEFAULT '' COMMENT '	用户刷新access_token',
  `scope` varchar(20)  DEFAULT '' COMMENT '用户授权的作用域，使用逗号（,）分隔  scope为 snsapi_userinfo时才可以拉取用户信息',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户授权日志';




CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `openid` varchar(100) NOT NULL COMMENT '用户昵称',
`nickname` varchar(100) NOT NULL COMMENT '用户唯一标识',
`sex` varchar(10) NOT NULL COMMENT '	用户的性别，值为1时是男性，值为2时是女性，值为0时是未知',
`province` varchar(50) NOT NULL COMMENT '用户个人资料填写的省份',
  `city` varchar(50) DEFAULT NULL COMMENT '普通用户个人资料填写的城市',
  `country` varchar(50) DEFAULT '' COMMENT '国家，如中国为CN',
	`headimgurl` varchar(300) DEFAULT '' COMMENT '用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。',
  `privilege` varchar(100)  DEFAULT '' COMMENT '用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）',
  `unionid` varchar(50)  DEFAULT '' COMMENT '	只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。',
  `create_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户详情表';



CREATE TABLE `user_token` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `uid` varchar(255) DEFAULT NULL COMMENT '用户id',
  `open_id` varchar(255) DEFAULT NULL COMMENT '用户唯一标识',
  `token` varchar(36) DEFAULT NULL COMMENT '密钥',
  `login_time` datetime DEFAULT NULL COMMENT '登陆时间 可更新',
  `expend_time` int(11) DEFAULT 3600 COMMENT '持续时间 1天',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户账号表';