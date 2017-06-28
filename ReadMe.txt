（3）数据库
数据库名：test
【user.sql】
SET FOREIGN_KEY_CHECKS=0;
-- ------------------------------ Table structure for user-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (  `id` int(11) NOT NULL,  `name` varchar(255) DEFAULT NULL,  `age` int(11) DEFAULT NULL,  `password` varchar(255) DEFAULT NULL,  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=latin1;
-- ------------------------------ Records of user-- ----------------------------
INSERT INTO `user` VALUES ('1', '7player', '18', '123456');



a.创建 cluster 数据库 springbootdb：

CREATE DATABASE springbootdb;
b.创建表 city ：(因为我喜欢徒步)

DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
`id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '城市编号',
`province_id` int(10) unsigned NOT NULL COMMENT '省份编号',
`city_name` varchar(25) DEFAULT NULL COMMENT '城市名称',
`description` varchar(25) DEFAULT NULL COMMENT '描述',
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
c.插入数据

INSERT city VALUES (1 ,1,'温岭市','BYSocket 的家在温岭。');
然后，再创建一个 master 数据库
a.创建数据库 springbootdb_cluster：


CREATE DATABASE springbootdb_cluster;
b.创建表 user ：

DROP TABLE IF EXISTS `city`;
CREATE TABLE user
(
id INT(10) unsigned PRIMARY KEY NOT NULL COMMENT '用户编号' AUTO_INCREMENT,
user_name VARCHAR(25) COMMENT '用户名称',
description VARCHAR(25) COMMENT '描述'
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
c.插入数据

INSERT user VALUES (1 ,’泥瓦匠','他有一个小网站 bysocket.com');
（以上数据库创建无先后顺序）




Controller
请求入口Controller部分提供三种接口样例：视图模板，Json，restful风格
（1）视图模板
返回结果为视图文件路径。视图相关文件默认放置在路径 resource/templates下：
http://localhost:8080/hello?name=QiQi
（2）Json
返回Json格式数据，多用于Ajax请求。
http://localhost:8080/getUserInfo
（3）restful
REST 指的是一组架构约束条件和原则。满足这些约束条件和原则的应用程序或设计就是 RESTful。
此外，有一款RESTFUL接口的文档在线自动生成+功能测试功能软件——Swagger UI，具体配置过程可移步《Spring Boot 利用 Swagger 实现restful测试》
http://localhost:8080/swagger/index.html



https://zhuanlan.zhihu.com/p/25069044?refer=dreawer