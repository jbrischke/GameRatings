delete from game;
INSERT INTO `game` VALUES (1,'https://www.enjpg.com/img/2020/cool-for-boys-4.jpg','Sierra', 'description'), (2,'https://www.enjpg.com/img/2020/cool-for-boys-4.jpg','Sierra', 'description'), (3,'https://www.enjpg.com/img/2020/cool-for-boys-4.jpg','Sierra', 'description');
delete from user;
INSERT INTO `user` VALUES (1,'Fred' , 'name' , 'joshbrischke@gmail.com'), (2,'Susan' , 'name' , 'joshbrischke@gmail.com'), (3,'Josh' , 'name' , 'joshbrischke@gmail.com');
delete from role;
INSERT INTO `role` VALUES (1,'user' , 1 , 'Fred'), (2,'user' , 2 , 'Susan'), (3,'user' , 3 , 'Josh');
