delete from game;
INSERT INTO `game` VALUES (1,'https://www.enjpg.com/img/2020/cool-for-boys-4.jpg','Sierra','game-name','description'), (2,'https://www.enjpg.com/img/2020/cool-for-boys-4.jpg','Sierra','game-name','description'), (3,'https://www.enjpg.com/img/2020/cool-for-boys-4.jpg','Sierra','game-name','description');
delete from user;
INSERT INTO `user` VALUES (1,'Fred' , 'name' , 'joshbrischke@gmail.com'), (2,'Susan' , 'name' , 'joshbrischke@gmail.com'), (3,'Josh' , 'name' , 'joshbrischke@gmail.com');
delete from role;
INSERT INTO `role` VALUES (1,'user' , 1 , 'Fred'), (2,'user' , 2 , 'Susan'), (3,'user' , 3 , 'Josh');
delete from report;
INSERT INTO `report` VALUES (1,'entry1','13', 1), (2,'entry1','22', 1), (3,'entry2','13', 2), (4,'entry2','22', 2), (5,'entry3','13', 3), (6,'entry3','22', 3);