create table user (
    id bigint not null auto_increment,
    created_at datetime(6) not null,
    email varchar(255) not null,
    gender integer not null,
    job varchar(255),
    last_login datetime(6),
    password varchar(255) not null,
    role integer not null,
    username varchar(255) not null,
    primary key (id)
) engine=InnoDB;
