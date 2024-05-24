CREATE TABLE `tb_attendance` (
	`attendance_id`	bigint	NOT NULL,
	`approval`	tinyint	NULL,
	`attendance_time`	datetime(6)	NULL,
	`create_at`	datetime(6)	NULL,
	`update_at`	datetime(6)	NULL,
	`dojo_id2`	bigint	NOT NULL,
	`user_id2`	bigint	NOT NULL
);

CREATE TABLE `tb_board` (
	`board_id`	bigint	NOT NULL,
	`name`	varchar(255)	NULL
);

CREATE TABLE `tb_chat` (
	`chat_id`	bigint	NOT NULL,
	`user_id`	bigint	NOT NULL,
	`chat_room_id`	bigint	NOT NULL,
	`create_at`	datetime(6)	NULL,
	`update_at`	datetime(6)	NULL
);

CREATE TABLE `tb_chat_room` (
	`chat_room_id`	bigint	NOT NULL,
	`create_at`	datetime(6)	NULL,
	`update_at`	datetime(6)	NULL
);

CREATE TABLE `tb_comment` (
	`comment_id`	bigint	NOT NULL,
	`post_id`	bigint	NOT NULL,
	`user_id`	bigint	NOT NULL
);

CREATE TABLE `tb_dojo` (
	`dojo_id`	bigint	NOT NULL,
	`user_id`	bigint	NOT NULL,
	`latitude`	float(53)	NULL,
	`longitude`	float(53)	NULL,
	`radius`	float(53)	NULL,
	`state`	tinyint	NULL,
	`create_at`	datetime(6)	NULL,
	`update_at`	datetime(6)	NULL,
	`dojo_code`	varchar(255)	NULL,
	`location`	varchar(255)	NULL,
	`name`	varchar(255)	NULL,
	`phone`	varchar(255)	NULL
);

CREATE TABLE `tb_lesson` (
	`lesson_id`	bigint	NOT NULL,
	`create_at`	datetime(6)	NULL,
	`end_time`	datetime(6)	NULL,
	`start_time`	datetime(6)	NULL,
	`update_at`	datetime(6)	NULL,
	`name`	varchar(255)	NULL,
	`dojo_id`	bigint	NOT NULL
);

CREATE TABLE `tb_notice` (
	`notice_id`	bigint	NOT NULL,
	`dojo_id`	bigint	NOT NULL,
	`create_at`	datetime(6)	NULL,
	`update_at`	datetime(6)	NULL,
	`content`	varchar(255)	NULL,
	`title`	varchar(255)	NULL
);

CREATE TABLE `tb_pass` (
	`pass_id`	bigint	NOT NULL,
	`user_id`	bigint	NOT NULL,
	`lesson_id`	bigint	NOT NULL,
	`expire_time`	datetime(6)	NULL
);

CREATE TABLE `tb_payment` (
	`payment_id`	bigint	NOT NULL,
	`create_at`	datetime(6)	NULL,
	`update_at`	datetime(6)	NULL,
	`pass_id`	bigint	NOT NULL,
	`user_id`	bigint	NOT NULL
);

CREATE TABLE `tb_post` (
	`post_id`	bigint	NOT NULL,
	`content`	varchar(255)	NULL,
	`title`	varchar(255)	NULL,
	`board_id2`	bigint	NOT NULL,
	`user_id`	bigint	NOT NULL
);

CREATE TABLE `tb_product` (
	`product_id`	bigint	NOT NULL,
	`dojo_id`	bigint	NULL,
	`amount`	varchar(255)	NULL,
	`name`	varchar(255)	NULL
);

CREATE TABLE `tb_schedule` (
	`schedule_id`	bigint	NOT NULL,
	`create_at`	datetime(6)	NULL,
	`update_at`	datetime(6)	NULL,
	`content`	varchar(255)	NULL,
	`title`	varchar(255)	NULL,
	`dojo_id`	bigint	NOT NULL
);

CREATE TABLE `tb_user` (
	`user_id`	bigint	NOT NULL,
	`create_at`	datetime(6)	NULL,
	`dojo_id`	bigint	NULL,
	`last_login_date`	datetime(6)	NULL,
	`update_at`	datetime(6)	NULL,
	`deleted`	varchar(255)	NULL,
	`email`	varchar(255)	NULL,
	`nickname`	varchar(255)	NULL,
	`role`	enum	NULL
);

ALTER TABLE `tb_attendance` ADD CONSTRAINT `PK_TB_ATTENDANCE` PRIMARY KEY (
	`attendance_id`
);

ALTER TABLE `tb_board` ADD CONSTRAINT `PK_TB_BOARD` PRIMARY KEY (
	`board_id`
);

ALTER TABLE `tb_chat` ADD CONSTRAINT `PK_TB_CHAT` PRIMARY KEY (
	`chat_id`
);

ALTER TABLE `tb_chat_room` ADD CONSTRAINT `PK_TB_CHAT_ROOM` PRIMARY KEY (
	`chat_room_id`
);

ALTER TABLE `tb_comment` ADD CONSTRAINT `PK_TB_COMMENT` PRIMARY KEY (
	`comment_id`
);

ALTER TABLE `tb_dojo` ADD CONSTRAINT `PK_TB_DOJO` PRIMARY KEY (
	`dojo_id`
);

ALTER TABLE `tb_lesson` ADD CONSTRAINT `PK_TB_LESSON` PRIMARY KEY (
	`lesson_id`
);

ALTER TABLE `tb_notice` ADD CONSTRAINT `PK_TB_NOTICE` PRIMARY KEY (
	`notice_id`
);

ALTER TABLE `tb_pass` ADD CONSTRAINT `PK_TB_PASS` PRIMARY KEY (
	`pass_id`
);

ALTER TABLE `tb_payment` ADD CONSTRAINT `PK_TB_PAYMENT` PRIMARY KEY (
	`payment_id`
);

ALTER TABLE `tb_post` ADD CONSTRAINT `PK_TB_POST` PRIMARY KEY (
	`post_id`
);

ALTER TABLE `tb_product` ADD CONSTRAINT `PK_TB_PRODUCT` PRIMARY KEY (
	`product_id`
);

ALTER TABLE `tb_schedule` ADD CONSTRAINT `PK_TB_SCHEDULE` PRIMARY KEY (
	`schedule_id`
);

ALTER TABLE `tb_user` ADD CONSTRAINT `PK_TB_USER` PRIMARY KEY (
	`user_id`
);

