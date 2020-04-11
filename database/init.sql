SET character_set_client = utf8;
SET character_set_results = utf8;
SET character_set_connection = utf8;

CREATE SCHEMA if not exists `stigershoppingaccount` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;

drop table if exists `stigershoppingaccount`.shopping_account;
create table `stigershoppingaccount`.shopping_account
(
    account_id       varchar(32) not null comment '账户id',
    account_name     varchar(50) not null comment '账户登录名',
    account_password varchar(100) comment '账户登录密码',
    delete_flag      varchar(2) default 'N' comment '删除标记',
    primary key (account_id)
);

CREATE SCHEMA if not exists `stigershoppinggoods` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;

drop table if exists `stigershoppinggoods`.shopping_goods;
create table `stigershoppinggoods`.shopping_goods
(
    goods_id      varchar(32)   not null comment '商品id',
    goods_name    varchar(500)  not null comment '商品名称',
    goods_factory varchar(500) comment '商品生产厂家',
    goods_content varchar(2000) comment '商品说明',
    goods_keyword varchar(2000) comment '商品标签',
    goods_price   decimal(8, 2) not null comment '商品价格',
    delete_flag   varchar(2) default 'N' comment '删除标记',
    primary key (goods_id)
);

CREATE SCHEMA if not exists `stigershoppingorder` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;

drop table if exists `stigershoppingorder`.shopping_order;
create table `stigershoppingorder`.shopping_order
(
    order_id       varchar(32) not null comment '订单id',
    order_datetime varchar(14) not null comment '下单订单时间',
    order_price    decimal(8, 2) comment '订单总价',
    delete_flag    varchar(2) default 'N' comment '删除标记',
    primary key (order_id)
);

drop table if exists `stigershoppingorder`.shopping_order_goods;
create table `stigershoppingorder`.shopping_order_goods
(
    order_goods_id varchar(32) not null comment '订单商品id',
    order_id       varchar(32) not null comment '订单id',
    goods_id       varchar(32) not null comment '商品id',
    goods_name     varchar(500) comment '商品名称',
    goods_price    decimal(8, 2) comment '商品单价',
    goods_num      int        default 1 comment '订单商品数量',
    price          decimal(8, 2) comment '总价',
    delete_flag    varchar(2) default 'N' comment '删除标记',
    primary key (order_goods_id)
);