create table reports
(
    reports_id  int auto_increment,
    description varchar(200) null,
    constraint reports_reports_id_uindex
        unique (reports_id)
);

alter table reports
    add primary key (reports_id);

create table games
(
    game_id     int auto_increment,
    gamepicture blob not null,
    constraint games_game_id_uindex
        unique (game_id),
    constraint games_reports_reports_id_fk
        foreign key (game_id) references reports (reports_id)
);

alter table games
    add primary key (game_id);

create table user
(
    user_id    int auto_increment,
    createdate timestamp    null,
    email      varchar(255) null,
    firstname  varchar(244) null,
    lastname   varchar(244) null,
    updatedate timestamp    null,
    username   varchar(255) null,
    constraint user_user_id_uindex
        unique (user_id)
);

alter table user
    add primary key (user_id);

create table roles
(
    role_id    int auto_increment,
    createdate timestamp    null,
    name       varchar(255) null,
    updatedate timestamp    null,
    constraint roles_role_id_uindex
        unique (role_id),
    constraint roles_user_user_id_fk
        foreign key (role_id) references user (user_id)
);

alter table roles
    add primary key (role_id);
