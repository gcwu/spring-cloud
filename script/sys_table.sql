/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.24 : Database - mywork
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mywork` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `mywork`;

/*Table structure for table `tb_sys_map_role_resource` */

DROP TABLE IF EXISTS `sys_map_role_resource`;

CREATE TABLE `sys_map_role_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` varchar(10) DEFAULT NULL COMMENT '角色编码',
  `resource_id` varchar(50) DEFAULT NULL COMMENT '菜单或资源编码 ',
  `resource_type` varchar(1) DEFAULT NULL COMMENT '类型；1-菜单，2-资源 ',
  `crate_user` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间 ',
  `update_user` varchar(50) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='角色和资源关联信息表';

/*Data for the table `sys_map_role_resource` */

insert  into `sys_map_role_resource`(`id`,`role_id`,`resource_id`,`resource_type`,`crate_user`,`create_time`,`update_user`,`update_time`) values (1,'1','1','1','GCWU',NULL,NULL,NULL),(2,'1','2','1','GCWU',NULL,NULL,NULL),(3,'1','3','1','GCWU',NULL,NULL,NULL),(4,'1','5','1','GCWU',NULL,NULL,NULL),(5,'1','4','1','GCWU',NULL,NULL,NULL);

/*Table structure for table `sys_map_user_role` */

DROP TABLE IF EXISTS `sys_map_user_role`;

CREATE TABLE `sys_map_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(50) DEFAULT NULL COMMENT '用户名id',
  `role_id` varchar(10) DEFAULT NULL COMMENT '角色id',
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(50) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `sys_map_user_role` */

insert  into `sys_map_user_role`(`id`,`user_id`,`role_id`,`create_user`,`create_time`,`update_user`,`update_time`) values (1,'1','1','GCWU',NULL,NULL,NULL);

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) DEFAULT NULL COMMENT '菜单编码',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(500) DEFAULT NULL COMMENT '菜单请求路径',
  `parent_id` int(11) DEFAULT NULL COMMENT '父菜单主键',
  `level` int(2) DEFAULT NULL COMMENT '菜单级别',
  `seq` int(8) DEFAULT NULL COMMENT '顺序号',
  `status` varchar(1) DEFAULT NULL COMMENT '状态;1-有效，0-无效',
  `remark` varchar(255) DEFAULT NULL COMMENT '描述 ',
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建人 ',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间 ',
  `updete_user` varchar(50) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`id`,`code`,`name`,`url`,`parent_id`,`level`,`seq`,`status`,`remark`,`create_user`,`create_time`,`updete_user`,`update_time`) values (1,'MENU1001','系统管理',NULL,NULL,1,1,'1','系统管理菜单','gcwu','2017-05-12 17:26:23',NULL,NULL),(2,'MENU1002','用户管理','user/usermanger',1,2,1,'1','用户管管理菜单','gcww','2017-05-12 17:28:39',NULL,NULL),(3,'MENU2001','业务模块',NULL,NULL,1,2,'1','业务模块1级菜单','gcww','2017-05-12 17:28:39',NULL,NULL),(4,'MENU2002','图表展示','report/index',3,2,1,'1',NULL,'gcww','2017-05-12 17:28:39',NULL,NULL),(5,'MENU1003','菜单管理','menu/menuManger',1,2,2,'1',NULL,'gcww',NULL,NULL,NULL);

/*Table structure for table `sys_resource` */

DROP TABLE IF EXISTS `sys_resource`;

CREATE TABLE `sys_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资源主键 ',
  `menu_id` int(11) DEFAULT NULL COMMENT '菜单主键 ',
  `code` varchar(50) DEFAULT NULL COMMENT '资源编码 ',
  `name` varchar(50) DEFAULT NULL COMMENT '资源名称 ',
  `url` varchar(500) DEFAULT NULL COMMENT '资源路径 ',
  `type` int(1) DEFAULT NULL COMMENT '类型；1-菜单，2-资源',
  `stauts` varchar(1) DEFAULT NULL COMMENT '状态;1-有效，0-无效',
  `description` varchar(255) DEFAULT NULL COMMENT '描述 ',
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间 ',
  `update_user` varchar(50) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户和角色关联信息表';

/*Data for the table `sys_resource` */

insert  into `sys_resource`(`id`,`menu_id`,`code`,`name`,`url`,`type`,`stauts`,`description`,`create_user`,`create_time`,`update_user`,`update_time`) values (1,2,'MENU1001','用户管理','user/userManger',1,'1',NULL,'gcwu','2017-05-30 19:09:35',NULL,NULL),(2,5,'MENU2001','菜单管理','menu/userManger',1,'1',NULL,NULL,'2017-05-30 19:09:37',NULL,NULL),(3,4,'RE0001','报表管理','report/index',1,'1',NULL,NULL,'2017-05-30 19:09:39',NULL,NULL);

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(10) DEFAULT NULL COMMENT '角色编码',
  `name` varchar(50) DEFAULT NULL COMMENT '角色名',
  `status` varchar(1) DEFAULT NULL COMMENT '状态  0-冻结 1-正常',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(50) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='角色信息表';

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`code`,`name`,`status`,`description`,`create_user`,`create_time`,`update_user`,`update_time`) values (1,'A001','管理员','1',NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) DEFAULT NULL COMMENT '登录密码',
  `user_type` varchar(1) DEFAULT NULL COMMENT '用户类型; 1-系统管理员，2-普通用户',
  `status` varchar(1) DEFAULT NULL COMMENT '状态  0-冻结 1-正常',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后一次登录时间',
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(50) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userId` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`userId`,`username`,`password`) values (1,'3','3');
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
