CREATE TABLE `t_student_course` (
   `id` int NOT NULL AUTO_INCREMENT,
   `courseName` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
   `courseTeacher` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
   `studentId` int DEFAULT NULL,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `t_student_parent` (
   `id` int NOT NULL AUTO_INCREMENT,
   `parentName` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
   `isMonOrDad` int DEFAULT NULL,
   `parentGender` int DEFAULT NULL,
   `studentId` int DEFAULT NULL,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `t_student_table` (
    `id` int NOT NULL AUTO_INCREMENT,
    `studentName` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `age` int DEFAULT NULL,
    `address` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `gender` int DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;