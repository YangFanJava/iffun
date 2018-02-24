
CREATE TABLE `user_auth_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `code` varchar(100) NOT NULL COMMENT '用户唯一标识',
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



CREATE TABLE `recyle_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `uid` int(11) NOT NULL COMMENT '下单用户',
  `price_id` int(11) DEFAULT NULL COMMENT '回收手机类型',
  `recyle_state` char(1) DEFAULT NULL COMMENT '回收进度 1 用户检测后回收中   5 回收中 6 回收结束未付款 7 回收结束已付款 订单结束',
  `recyle_type` char(255) DEFAULT NULL COMMENT '回收类型  0 店铺回收 1 快递回收  2 上门回收 ',
  `qa_user` varchar(255) DEFAULT '' COMMENT '回收问题 用户',
  `qa_business` varchar(255) DEFAULT '' COMMENT '回收问题  商家重新测试',
  `estimate_price_user` decimal(10,2) DEFAULT NULL COMMENT '回收价格 用户测算价格',
  `is_auditing` char(1) DEFAULT NULL COMMENT '是否审核',
  `auditing_price` decimal(10,2) DEFAULT NULL COMMENT '商家评估价格',
  `pay_state` char(1) DEFAULT NULL COMMENT '支付状态  0 未支付  1 已支付',
  `pay_type` char(1) DEFAULT NULL COMMENT '支付类型  1 微信  1 支付宝',
  `pay_name` char(1) DEFAULT NULL COMMENT '支付名',
  `pay_account` char(1) DEFAULT NULL COMMENT '支付名',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名称',
  `user_phone` varchar(30) DEFAULT NULL COMMENT '用户联系方式',
  `express_code` varchar(100) DEFAULT NULL COMMENT '快递单号',
  `appointment_time` datetime DEFAULT NULL COMMENT '预约时间',
  `create_time` datetime DEFAULT NULL COMMENT '订单创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '订单修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='回收订单表';


CREATE TABLE `order_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `user_name` varchar(100) NOT NULL COMMENT '用户名称',
  `user_address` varchar(100) NOT NULL COMMENT '地区',
  `pid` int(11) DEFAULT NULL COMMENT '商品id',
  `product_name` varchar(50) DEFAULT NULL COMMENT '商品名称',
  `product_image` varchar(200) DEFAULT NULL COMMENT '商品图片',
  `oid` int(11) DEFAULT NULL COMMENT '订单id',
  `recyle_price` decimal(10,2) DEFAULT NULL COMMENT '成交金额',
  `text` varchar(300) DEFAULT NULL COMMENT '评论正文',
  `recyle_type` varchar(20) DEFAULT '0' COMMENT '回收方式',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `is_show` char(1) DEFAULT NULL,
  `sort` int(11) DEFAULT '100',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='用户评论表';
