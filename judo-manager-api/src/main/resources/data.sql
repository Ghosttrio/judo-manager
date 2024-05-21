create table IF NOT EXISTS chat (
    chat_id bigint not null auto_increment,
    chat_room_id bigint,
    create_at datetime(6),
    update_at datetime(6),
    user_id bigint,
    primary key (chat_id)
);

create table IF NOT EXISTS chat_room (
    chat_room_id bigint not null auto_increment,
    create_at datetime(6),
    update_at datetime(6),
    primary key (chat_room_id)
);

create table IF NOT EXISTS dojo (
    state tinyint check (state between 0 and 3),
    create_at datetime(6),
    dojo_id bigint not null auto_increment,
    master_id bigint,
    update_at datetime(6),
    dojo_code varchar(255),
    location varchar(255),
    name varchar(255),
    phone varchar(255),
    primary key (dojo_id)
);

create table IF NOT EXISTS notice (
    create_at datetime(6),
    dojo_id bigint,
    notice_id bigint not null auto_increment,
    update_at datetime(6),
    content varchar(255),
    title varchar(255),
    primary key (notice_id)
);

create table IF NOT EXISTS payment (
    create_at datetime(6),
    payment_id bigint not null auto_increment,
    update_at datetime(6),
    user_id bigint,
    amount varchar(255),
    product varchar(255),
    primary key (payment_id)
);

create table IF NOT EXISTS schedule (
    create_at datetime(6),
    dojo_id bigint,
    schedule_id bigint not null auto_increment,
    update_at datetime(6),
    content varchar(255),
    title varchar(255),
    primary key (schedule_id)
);

create table IF NOT EXISTS tb_attendance (
    approval tinyint check (approval between 0 and 2),
    attendance_id bigint not null auto_increment,
    create_at datetime(6),
    dojo_id bigint,
    update_at datetime(6),
    user_id bigint,
    primary key (attendance_id)
);

create table IF NOT EXISTS tb_board (
    board_id bigint not null auto_increment,
    name varchar(255),
    primary key (board_id)
);

create table IF NOT EXISTS tb_comment (
    comment_id bigint not null auto_increment,
    user_id bigint,
    primary key (comment_id)
);

create table IF NOT EXISTS tb_post (
    board_id bigint,
    post_id bigint not null auto_increment,
    content varchar(255),
    title varchar(255),
    primary key (post_id)
);

create table IF NOT EXISTS tb_user (
    create_at datetime(6),
    dojo_id bigint,
    update_at datetime(6),
    user_id bigint not null auto_increment,
    deleted varchar(255),
    email varchar(255),
    nickname varchar(255),
    role enum ('MASTER','MEMBER'),
    primary key (user_id)
);