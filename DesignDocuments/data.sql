create table games
(
    id          int auto_increment,
    gameURL     varchar(255) null,
    description varchar(255) null,
    name        varchar(255) null,
    constraint games_game_id_uindex
        unique (id)
);

alter table games
    add primary key (id);

create table reports
(
    id          int auto_increment,
    description varchar(200) null,
    hoursPlayed int          null,
    constraint reports_reports_id_uindex
        unique (id),
    constraint reports_games_id_fk
        foreign key (id) references games (id)
            on update cascade on delete cascade
);

alter table reports
    add primary key (id);

create table user
(
    user_id  int auto_increment,
    username varchar(255) null,
    constraint user_user_id_uindex
        unique (user_id)
);

alter table user
    add primary key (user_id);

create table roles
(
    role_id int auto_increment,
    name    varchar(255) null,
    constraint roles_role_id_uindex
        unique (role_id),
    constraint roles_user_user_id_fk
        foreign key (role_id) references user (user_id)
            on update cascade on delete cascade
);

alter table roles
    add primary key (role_id);
