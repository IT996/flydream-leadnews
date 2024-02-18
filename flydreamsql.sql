/*
SQLyog v10.2 
MySQL - 5.7.24-log : Database - flydream-leadnews
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`flydream-leadnews` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `flydream-leadnews`;

/*Table structure for table `ap_article` */

DROP TABLE IF EXISTS `ap_article`;

CREATE TABLE `ap_article` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标题',
  `author_id` int(11) unsigned DEFAULT NULL COMMENT '文章作者的ID',
  `author_name` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '作者昵称',
  `channel_id` int(10) unsigned DEFAULT NULL COMMENT '文章所属频道ID',
  `channel_name` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '频道名称',
  `layout` tinyint(1) unsigned DEFAULT NULL COMMENT '文章布局\r\n            0 无图文章\r\n            1 单图文章\r\n            2 多图文章',
  `flag` tinyint(3) unsigned DEFAULT NULL COMMENT '文章标记\r\n            0 普通文章\r\n            1 热点文章\r\n            2 置顶文章\r\n            3 精品文章\r\n            4 大V 文章',
  `images` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '文章图片\r\n            多张逗号分隔',
  `labels` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '文章标签最多3个 逗号分隔',
  `likes` int(5) unsigned DEFAULT NULL COMMENT '点赞数量',
  `collection` int(5) unsigned DEFAULT NULL COMMENT '收藏数量',
  `comment` int(5) unsigned DEFAULT NULL COMMENT '评论数量',
  `views` int(5) unsigned DEFAULT NULL COMMENT '阅读数量',
  `province_id` int(11) unsigned DEFAULT NULL COMMENT '省市',
  `city_id` int(11) unsigned DEFAULT NULL COMMENT '市区',
  `county_id` int(11) unsigned DEFAULT NULL COMMENT '区县',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `publish_time` datetime DEFAULT NULL COMMENT '发布时间',
  `sync_status` tinyint(1) DEFAULT '0' COMMENT '同步状态',
  `origin` tinyint(1) unsigned DEFAULT '0' COMMENT '来源',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='文章信息表，存储已发布的文章';

/*Data for the table `ap_article` */

/*Table structure for table `ap_behavior_entry` */

DROP TABLE IF EXISTS `ap_behavior_entry`;

CREATE TABLE `ap_behavior_entry` (
  `id` int(11) unsigned NOT NULL COMMENT '主键',
  `type` tinyint(1) unsigned DEFAULT NULL COMMENT '实体类型\r\n            0终端设备\r\n            1用户',
  `entry_id` int(11) unsigned DEFAULT NULL COMMENT '实体ID',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `burst` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分片',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='APP行为实体表,一个行为实体可能是用户或者设备，或者其它';

/*Data for the table `ap_behavior_entry` */

/*Table structure for table `ap_show_behavior` */

DROP TABLE IF EXISTS `ap_show_behavior`;

CREATE TABLE `ap_show_behavior` (
  `id` int(11) unsigned NOT NULL,
  `entry_id` int(11) unsigned DEFAULT NULL COMMENT '实体ID',
  `article_id` int(11) unsigned DEFAULT NULL COMMENT '文章ID',
  `is_click` tinyint(1) unsigned DEFAULT NULL COMMENT '是否点击',
  `show_time` datetime DEFAULT NULL COMMENT '文章加载时间',
  `created_time` datetime DEFAULT NULL COMMENT '登录时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_entry_id` (`entry_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='APP文章展现行为表';

/*Data for the table `ap_show_behavior` */

/*Table structure for table `ap_user_article_list` */

DROP TABLE IF EXISTS `ap_user_article_list`;

CREATE TABLE `ap_user_article_list` (
  `id` int(11) unsigned NOT NULL COMMENT '主键',
  `user_id` int(11) unsigned DEFAULT NULL COMMENT '用户ID',
  `channel_id` int(11) unsigned DEFAULT NULL COMMENT '频道ID',
  `article_id` int(11) unsigned DEFAULT NULL COMMENT '动态ID',
  `is_show` tinyint(1) unsigned DEFAULT NULL COMMENT '是否展示',
  `recommend_time` datetime DEFAULT NULL COMMENT '推荐时间',
  `is_read` tinyint(1) unsigned DEFAULT NULL COMMENT '是否阅读',
  `strategy_id` int(5) unsigned DEFAULT NULL COMMENT '推荐算法',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='APP用户文章列表';

/*Data for the table `ap_user_article_list` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
