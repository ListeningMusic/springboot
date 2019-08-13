create table testdb
(
  id            int auto_increment
    primary key,
  name          varchar(255) null,
  account_id    varchar(100) null,
  token         char(36)     null,
  create_time   bigint       null,
  modified_time bigint       null
);
