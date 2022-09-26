INSERT INTO `rob_necessities`.`t_student_table` (`id`, `studentName`, `age`, `address`, `gender`) VALUES (1, '王小明', 15, '西安市临潼区', 1);
INSERT INTO `rob_necessities`.`t_student_table` (`id`, `studentName`, `age`, `address`, `gender`) VALUES (2, '李阳', 16, '西安市未央区', 0);
INSERT INTO `rob_necessities`.`t_student_table` (`id`, `studentName`, `age`, `address`, `gender`) VALUES (3, '潘倩', 15, '西安市雁塔区', 1);
INSERT INTO `rob_necessities`.`t_student_table` (`id`, `studentName`, `age`, `address`, `gender`) VALUES (4, '孙超', 16, '甘肃省兰州市', 0);


INSERT INTO `rob_necessities`.`t_student_parent` (`id`, `parentName`, `isMonOrDad`, `parentGender`, `studentId`) VALUES (1, '王昆', 0, 35, 1);
INSERT INTO `rob_necessities`.`t_student_parent` (`id`, `parentName`, `isMonOrDad`, `parentGender`, `studentId`) VALUES (2, '赵晓', 1, 34, 1);
INSERT INTO `rob_necessities`.`t_student_parent` (`id`, `parentName`, `isMonOrDad`, `parentGender`, `studentId`) VALUES (3, '李小刚', 0, 33, 2);
INSERT INTO `rob_necessities`.`t_student_parent` (`id`, `parentName`, `isMonOrDad`, `parentGender`, `studentId`) VALUES (4, '王明', 1, 33, 2);
INSERT INTO `rob_necessities`.`t_student_parent` (`id`, `parentName`, `isMonOrDad`, `parentGender`, `studentId`) VALUES (5, '潘程佳', 0, 34, 3);
INSERT INTO `rob_necessities`.`t_student_parent` (`id`, `parentName`, `isMonOrDad`, `parentGender`, `studentId`) VALUES (6, '张华', 1, 34, 3);
INSERT INTO `rob_necessities`.`t_student_parent` (`id`, `parentName`, `isMonOrDad`, `parentGender`, `studentId`) VALUES (7, '王小影', 1, 32, 4);
INSERT INTO `rob_necessities`.`t_student_parent` (`id`, `parentName`, `isMonOrDad`, `parentGender`, `studentId`) VALUES (8, '刘铭', 0, 31, 4);


INSERT INTO `rob_necessities`.`t_student_course` (`id`, `courseName`, `courseTeacher`, `studentId`) VALUES (1, '物理', '潘东', 1);
INSERT INTO `rob_necessities`.`t_student_course` (`id`, `courseName`, `courseTeacher`, `studentId`) VALUES (2, '化学', '靖哲', 1);
INSERT INTO `rob_necessities`.`t_student_course` (`id`, `courseName`, `courseTeacher`, `studentId`) VALUES (3, '数学', '郝文涛', 1);
INSERT INTO `rob_necessities`.`t_student_course` (`id`, `courseName`, `courseTeacher`, `studentId`) VALUES (4, '语文', '李延', 1);
INSERT INTO `rob_necessities`.`t_student_course` (`id`, `courseName`, `courseTeacher`, `studentId`) VALUES (5, '物理', '潘东', 2);
INSERT INTO `rob_necessities`.`t_student_course` (`id`, `courseName`, `courseTeacher`, `studentId`) VALUES (6, '化学', '靖哲', 2);
INSERT INTO `rob_necessities`.`t_student_course` (`id`, `courseName`, `courseTeacher`, `studentId`) VALUES (7, '数学', '郝文涛', 2);
INSERT INTO `rob_necessities`.`t_student_course` (`id`, `courseName`, `courseTeacher`, `studentId`) VALUES (8, '语文', '李延', 2);
INSERT INTO `rob_necessities`.`t_student_course` (`id`, `courseName`, `courseTeacher`, `studentId`) VALUES (9, '物理', '潘东', 3);
INSERT INTO `rob_necessities`.`t_student_course` (`id`, `courseName`, `courseTeacher`, `studentId`) VALUES (10, '化学', '靖哲', 3);
INSERT INTO `rob_necessities`.`t_student_course` (`id`, `courseName`, `courseTeacher`, `studentId`) VALUES (11, '数学', '郝文涛', 3);
INSERT INTO `rob_necessities`.`t_student_course` (`id`, `courseName`, `courseTeacher`, `studentId`) VALUES (12, '语文', '李延', 3);
INSERT INTO `rob_necessities`.`t_student_course` (`id`, `courseName`, `courseTeacher`, `studentId`) VALUES (13, '物理', '潘东', 4);
INSERT INTO `rob_necessities`.`t_student_course` (`id`, `courseName`, `courseTeacher`, `studentId`) VALUES (14, '化学', '靖哲', 4);
INSERT INTO `rob_necessities`.`t_student_course` (`id`, `courseName`, `courseTeacher`, `studentId`) VALUES (15, '数学', '郝文涛', 4);
INSERT INTO `rob_necessities`.`t_student_course` (`id`, `courseName`, `courseTeacher`, `studentId`) VALUES (16, '语文', '李延', 4);
