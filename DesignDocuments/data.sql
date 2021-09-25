CREATE DATABASE GameReports;

CONSTRAINT user PRIMARY KEY (userId)

CREATE TABLE user (
                      userId int,
                      createDate timestamp ,
                      email varchar(255),
                      firstName varchar(255),
                      lastName varchar(255),
                      password varchar(255),
                      updateDate timestamp,
                      userName varchar(255)
);

CREATE TABLE role (
                      roleId int,
                      createDate timestamp,
                      name varchar(255),
                      updateDate timestamp,
                      userName varchar(255)
);

CREATE TABLE report (
                      reportId int,
                      description varchar (255),

);


