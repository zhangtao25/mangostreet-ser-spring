create table `user`
(
    `user_id`       varchar(32) not null,
    `user_token`    varchar(32) not null,
    `user_phone`    varchar(32) not null comment '手机号',
    `user_email`    varchar(32) not null comment '邮箱',
    `user_password` varchar(32) not null comment '密码',
    `user_nikename` varchar(32) not null comment '昵称',
    `create_time`   timestamp   not null default current_timestamp comment '创建时间',
    `update_time`   timestamp   not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`user_id`)
) comment '用户表';

create table `userinfo`
(
    `userinfo_id`       varchar(32) not null,
    `userinfo_gender`   varchar(32) not null comment '性别',
    `userinfo_birthday` varchar(32) not null comment '生日',
    `user_id`           varchar(32) not null,
    `create_time`       timestamp   not null default current_timestamp comment '创建时间',
    `update_time`       timestamp   not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`userinfo_id`),
    key `idx_user_id` (`user_id`)
) comment '用户信息表';

create table `note`
(
    `note_id`          varchar(32)  not null,
    `note_type`        varchar(32)  not null comment '类型',
    `note_title`       varchar(32)  not null comment '标题',
    `note_description` varchar(32)  not null comment '描述',
    `note_content`     varchar(128) not null comment '内容',
    `user_id`          varchar(32)  not null,
    `create_time`      timestamp    not null default current_timestamp comment '创建时间',
    `update_time`      timestamp    not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`note_id`),
    key `idx_user_id` (`user_id`)
) comment '笔记表';

create table `note_image`
(
    `image_id`    varchar(32) not null,
    `image_url`   varchar(64) not null comment '图片地址',
    `note_id`     varchar(32) not null,
    `create_time` timestamp   not null default current_timestamp comment '创建时间',
    `update_time` timestamp   not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`image_id`),
    key `idx_note_id` (`note_id`)
) comment '笔记图片表';