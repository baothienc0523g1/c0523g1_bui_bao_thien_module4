create database module4_test_data;
use module4_test_data;

CREATE TABLE accounts (
    id INT PRIMARY KEY AUTO_INCREMENT,
    create_date DATE,
    user_name VARCHAR(30),
    account_password VARCHAR(255),
    is_deleted BIT DEFAULT 0
);

CREATE TABLE roles (
    id INT PRIMARY KEY AUTO_INCREMENT,
    role_name VARCHAR(50),
    is_deleted BIT DEFAULT 0
);

CREATE TABLE user_roles (
    id INT PRIMARY KEY AUTO_INCREMENT,
    account_id INT,
    role_id INT,
    FOREIGN KEY (account_id)
        REFERENCES accounts (id),
    FOREIGN KEY (role_id)
        REFERENCES roles (id),
    is_deleted BIT DEFAULT 0
);

CREATE TABLE classes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    class_name VARCHAR(30),
    class_description LONGTEXT,
    class_start_date DATE,
    class_end_date DATE,
    is_deleted BOOLEAN DEFAULT FALSE
);

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    student_name VARCHAR(50),
    identity VARCHAR(30),
    birthday DATE,
    gender INT,
    phone VARCHAR(30),
    graduate_point INT,
    address LONGTEXT,
    account_id INT,
    class_id INT,
    FOREIGN KEY (account_id)
        REFERENCES accounts (id),
    FOREIGN KEY (class_id)
        REFERENCES classes (id),
    is_deleted BIT DEFAULT 0
);

CREATE TABLE teachers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    teacher_name VARCHAR(50),
    identity VARCHAR(20),
    birthday DATE,
    gender INT,
    phone VARCHAR(30),
    salary BIGINT,
    address VARCHAR(200),
    account_id INT,
    is_deleted BIT DEFAULT 0,
    FOREIGN KEY (account_id)
        REFERENCES accounts (id)
);
CREATE TABLE assignments (
    id INT PRIMARY KEY AUTO_INCREMENT,
    date_start DATE,
    date_end DATE,
    teacher_id INT,
    class_id INT,
    is_deleted BIT DEFAULT 0,
    FOREIGN KEY (teacher_id)
        REFERENCES teachers (id),
    FOREIGN KEY (class_id)
        REFERENCES classes (id)
);
CREATE TABLE qualifications (
    id INT PRIMARY KEY AUTO_INCREMENT,
    qualification_name VARCHAR(30),
    qualification_fee BIGINT,
    course_duration INT,
    qualification_description LONGTEXT,
    is_deleted BIT DEFAULT 0
);
CREATE TABLE contracts (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fee BIGINT,
    contract_date DATE,
    student_id INT,
    qualification_id INT,
    is_deleted BIT DEFAULT 0,
    FOREIGN KEY (student_id)
        REFERENCES students (id),
    FOREIGN KEY (qualification_id)
        REFERENCES qualifications (id)
);

CREATE TABLE schedules_booking_history (
    id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT,
    class_id INT,
    booking_date DATE,
    schedule_booking_status BOOLEAN DEFAULT FALSE,
    is_deleted BIT DEFAULT 0,
    FOREIGN KEY (student_id)
        REFERENCES students (id),
    FOREIGN KEY (class_id)
        REFERENCES classes (id)
);

CREATE TABLE students_status (
    id INT PRIMARY KEY AUTO_INCREMENT,
    status_name VARCHAR(30),
    is_deleted BIT DEFAULT 0
);

CREATE TABLE students_history (
    id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT,
    class_id INT,
    status_id INT DEFAULT 0,
    FOREIGN KEY (student_id)
        REFERENCES students (id),
    FOREIGN KEY (class_id)
        REFERENCES classes (id),
    FOREIGN KEY (status_id)
        REFERENCES students_status (id),
    is_deleted BIT DEFAULT 0
);

-- ----dữ liệu bảng role---------
INSERT INTO `roles` (`id`, `role_name`) VALUES (1, 'ROLE_ADMIN');
INSERT INTO `roles` (`id`, `role_name`) VALUES (2, 'ROLE_TEACHER');
INSERT INTO `roles` (`id`, `role_name`) VALUES (3, 'ROLE_STUDENT');

-- dữ liệu bảng account-- 
INSERT INTO `accounts` ( `user_name`, `account_password`, `create_date`) VALUES ('ductrung@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', '2023-09-10');
INSERT INTO `accounts` ( `user_name`, `account_password`, `create_date`) VALUES ( 'noimandembuongxuong@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', '2023-08-10');
INSERT INTO `accounts` ( `user_name`, `account_password`, `create_date`) VALUES ( 'myhanh@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', '2022-06-12');
INSERT INTO `accounts` ( `user_name`, `account_password`, `create_date`) VALUES ( 'quocsang@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', '2022-02-11');
-- account hoc sinh --
INSERT INTO `accounts` ( `user_name`, `account_password`, `create_date`) VALUES ( 'chauton@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', '2022-01-20');
INSERT INTO `accounts` ( `user_name`, `account_password`, `create_date`) VALUES ( 'cuongha@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', '2023-07-30');
INSERT INTO `accounts` ( `user_name`, `account_password`, `create_date`) VALUES ( 'anhlam@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', '2023-09-12');
INSERT INTO `accounts` ( `user_name`, `account_password`, `create_date`) VALUES ( 'quyenpham@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', '2022-11-16');
INSERT INTO `accounts` ( `user_name`, `account_password`, `create_date`) VALUES ( 'tienngo@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', '2023-12-09');
INSERT INTO `accounts` ( `user_name`, `account_password`, `create_date`) VALUES ( 'duyton@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', '2022-10-12');
INSERT INTO `accounts` ( `user_name`, `account_password`, `create_date`) VALUES ( 'nhipham@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', '2022-09-25');
INSERT INTO `accounts` ( `user_name`, `account_password`, `create_date`) VALUES ( 'khuonglu@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', '2022-04-05');
INSERT INTO `accounts` ( `user_name`, `account_password`, `create_date`) VALUES ( 'phuonghoang@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', '2022-05-01');
INSERT INTO `accounts` ( `user_name`, `account_password`, `create_date`) VALUES ( 'thuyhoang@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', '2023-05-19');
INSERT INTO `accounts` ( `user_name`, `account_password`, `create_date`) VALUES ( 'nguyenphan@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', '2023-02-19');
INSERT INTO `accounts` ( `user_name`, `account_password`, `create_date`) VALUES ( 'tampham@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', '2023-10-19');
INSERT INTO `accounts` ( `user_name`, `account_password`, `create_date`) VALUES ( 'lyngo@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', '2023-07-19');
INSERT INTO `accounts` ( `user_name`, `account_password`, `create_date`) VALUES ( 'tranlinhsan@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', '2023-08-19');
-- acount giang vien--
INSERT INTO `accounts` ( `user_name`, `account_password`, `create_date`) VALUES ( 'haihuynh@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', '2023-08-19');
INSERT INTO `accounts` ( `user_name`, `account_password`, `create_date`) VALUES ( 'minhdo@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', '2023-06-23');
INSERT INTO `accounts` ( `user_name`, `account_password`, `create_date`) VALUES ( 'tannguyen@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', '2023-09-15');
INSERT INTO `accounts` ( `user_name`, `account_password`, `create_date`) VALUES ( 'hapham@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', '2023-11-18');
INSERT INTO `accounts` ( `user_name`, `account_password`, `create_date`) VALUES ( 'khangpham@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', '2023-12-17');
INSERT INTO `accounts` ( `user_name`, `account_password`, `create_date`) VALUES ( 'daotran@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', '2023-01-16');
INSERT INTO `accounts` ( `user_name`, `account_password`, `create_date`) VALUES ( 'phuocma@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', '2023-05-20');
INSERT INTO `accounts` ( `user_name`, `account_password`, `create_date`) VALUES ( 'giangapho@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', '2023-08-21');
INSERT INTO `accounts` ( `user_name`, `account_password`, `create_date`) VALUES ( 'truonganhngoc@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', '2023-03-19');
INSERT INTO `accounts` ( `user_name`, `account_password`, `create_date`) VALUES ( 'thiencatmoi', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', '2023-03-19');


-- dữ liệu bảng user_role-----
INSERT INTO `user_roles` (`account_id`, `role_id`) VALUES ( 1, 1);
INSERT INTO `user_roles` (`account_id`, `role_id`) VALUES ( 2, 1);
INSERT INTO `user_roles` (`account_id`, `role_id`) VALUES ( 3, 1);
INSERT INTO `user_roles` ( `account_id`, `role_id`) VALUES ( 4, 1);

INSERT INTO `user_roles` (`account_id`, `role_id`) VALUES ( 5, 3);
INSERT INTO `user_roles` (`account_id`, `role_id`) VALUES ( 6, 3);
INSERT INTO `user_roles` (`account_id`, `role_id`) VALUES ( 7, 3);
INSERT INTO `user_roles` (`account_id`, `role_id`) VALUES ( 8, 3);
INSERT INTO `user_roles` (`account_id`, `role_id`) VALUES ( 9, 3);
INSERT INTO `user_roles` (`account_id`, `role_id`) VALUES (10, 3);
INSERT INTO `user_roles` (`account_id`, `role_id`) VALUES (11, 3);
INSERT INTO `user_roles` ( `account_id`, `role_id`) VALUES (12, 3);
INSERT INTO `user_roles` ( `account_id`, `role_id`) VALUES (13, 3);
INSERT INTO `user_roles` ( `account_id`, `role_id`) VALUES (14, 3);
INSERT INTO `user_roles` ( `account_id`, `role_id`) VALUES (15, 3);
INSERT INTO `user_roles` ( `account_id`, `role_id`) VALUES (16, 3);
INSERT INTO `user_roles` ( `account_id`, `role_id`) VALUES (17, 3);
INSERT INTO `user_roles` ( `account_id`, `role_id`) VALUES (18, 3);

INSERT INTO `user_roles` ( `account_id`, `role_id`) VALUES (19, 2);
INSERT INTO `user_roles` ( `account_id`, `role_id`) VALUES (20, 2);
INSERT INTO `user_roles` ( `account_id`, `role_id`) VALUES (21, 2);
INSERT INTO `user_roles` ( `account_id`, `role_id`) VALUES (22, 2);
INSERT INTO `user_roles` ( `account_id`, `role_id`) VALUES (23, 2);
INSERT INTO `user_roles` ( `account_id`, `role_id`) VALUES (24, 2);
INSERT INTO `user_roles` ( `account_id`, `role_id`) VALUES (25, 2);
INSERT INTO `user_roles` ( `account_id`, `role_id`) VALUES (26, 2);
INSERT INTO `user_roles` ( `account_id`, `role_id`) VALUES (27, 2);


-- -----dữ liệu bảng classes----
insert into `classes` (`class_name`,`class_description`,`class_start_date`,`class_end_date`) values('B2-0723','đây là mô tả về lớp học này','2023-07-05','2023-10-05');
insert into `classes` (`class_name`,`class_description`,`class_start_date`,`class_end_date`) values('B2-0923','đây là mô tả về lớp học này','2023-09-05','2023-12-05');
insert into `classes` (`class_name`,`class_description`,`class_start_date`,`class_end_date`) values('B2-1023','đây là mô tả về lớp học này','2023-10-05','2024-01-05');
insert into `classes` (`class_name`,`class_description`,`class_start_date`,`class_end_date`) values('C-0323','đây là mô tả về lớp học này','2023-03-02','2023-08-02');
insert into `classes` (`class_name`,`class_description`,`class_start_date`,`class_end_date`) values('C-0423','đây là mô tả về lớp học này','2023-04-02','2023-09-02');
insert into `classes` (`class_name`,`class_description`,`class_start_date`,`class_end_date`) values('C-0723','đây là mô tả về lớp học này','2023-07-02','2023-12-02');
insert into `classes` (`class_name`,`class_description`,`class_start_date`,`class_end_date`) values('D-0423','đây là mô tả về lớp học này','2023-04-10','2023-10-10');
insert into `classes` (`class_name`,`class_description`,`class_start_date`,`class_end_date`) values('D-0723','đây là mô tả về lớp học này','2023-07-10','2024-01-10');
insert into `classes` (`class_name`,`class_description`,`class_start_date`,`class_end_date`) values('D-0823','đây là mô tả về lớp học này','2023-08-10','2024-02-10');


-- dữ liệu bảng students----
insert into `students`(`student_name`, `identity`, `birthday`,`gender`,`phone`,`graduate_point`,`address`,`account_id`,`class_id`)
values
('Tôn Nữ Mộc Châu','202000001','2000-01-16', 0,'3222584418', 80, '25, Đường Trần Phú, Thành phố Hải Phòng, Tỉnh Hải Phòng', 4, 1),
('Hà Phi Cường','5006828120','1985-02-10', 1,'0701123456', 92, '15, Đường Lê Lợi, Thành phố Đà Nẵng, Tỉnh Đà Nẵng', 5, 1),
('Lâm Tùng Anh','3222584418','1991-06-16', 1,'6199675255', 87, '80 Đường Nguyễn Du, Thành phố Hà Nội, Tỉnh Hà Nội', 6, 1),
('Phạm Thế Quyền','1234567890', '1991-06-16',1,'4686623236', 78, '30, Đường Nguyễn Huệ, Thành phố Hồ Chí Minh, Tỉnh Hồ Chí Minh', 7, 1),
('Ngô Vân Tiên','0123456789' ,'1981-09-30' ,1, '8203545498',91, '5, Đường Trần Hưng Đạo, Thành phố Cần Thơ, Tỉnh Cần Thơ', 8, 1),
('Tôn Thất Khánh Duy','7896543211','1993-08-07', 1,'0987654321' , 84, '12, Đường Nguyễn Công Trứ, Thành phố Huế, Tỉnh Thừa Thiên Huế', 9, 1),
('Phạm Hải Nhi','3618250612','1989-12-30', 0,'3618250612' , 85, '8, Đường Ngô Quyền, Thành phố Hải Dương, Tỉnh Hải Dương', 10, 1),
('Lư Đăng Khương','3618250612','1980-09-18', 1,'3831465457' , 75, '18, Đường Trần Nhân Tông, Thành phố Vinh, Tỉnh Nghệ An', 11, 1),
('Hoàng Thu Phượng','3618250612','1986-08-07', 0,'8129079378' , 83, '20, Đường Lê Lợi, Thành phố Nha Trang, Tỉnh Khánh Hòa', 12, 1),
('Hoàng Cẩm Thúy','3618250612','1987-12-17', 0,'2427482439' , 81, '8, Đường Ngô Gia Tự, Thành phố Hải Dương, Tỉnh Hải Dương ', 13, 1),
('Phan Ðình Nguyên','3618250612','1987-07-20', 0,'0987213738' , 89, '5, Đường Trần Hưng Đạo, Thành phố Cần Thơ, Tỉnh Cần Thơ ', 14, 1),
('Phạm Khải Tâm','3618250612','1990-08-24', 1,'8866340294' , 82, '27, Đường Trần Hưng Đạo, Thành phố Lạng Sơn ', 15, 1),
('Ngô Thiều Ly','3618250612','1987-10-28', 0,'3976194594' , 95, '"24, Đường Lê Duẩn, Thành phố Tam Kỳ, Tỉnh Quảng Nam', 16, 1),
('Trần Linh San','3618250612','1989-12-30', 0,'1987-10-02' , 83, '23, Đường Trần Bình Trọng, Thành phố Bạc Liêu, Tỉnh Bạc Liêu ', 17, 1);



-- dữ liệu bảng teachers----
insert into `teachers` (`teacher_name`,`identity`,`birthday`,`gender`,`phone`,`salary`,`address`,`account_id`) 
values
('Huỳnh Phi Hải', '2427482439', '1987-12-17', 1, '0123456789', 7000000,'22, Đường Lê Thánh Tôn, Thành phố Vũng Tàu, Tỉnh Bà Rịa-Vũng Tàu',19),
('Đỗ Hồng Minh','8866340294' ,'1987-10-28' , 1, '7418346803', 8000000,'10, Đường Lê Lợi, Thành phố Hà Nội, Tỉnh Hà Nội',20),
('Nguyễn Trọng Tấn','4507416926', '1980-12-03', 1, '3371554645', 8000000 ,'25, Đường Trần Phú, Thành phố Hải Phòng, Tỉnh Hải Phòng',21),
('Phạm Thanh Hà','1643493604' ,'1987-10-02' ,0 , '7014117555', 9000000,'15, Đường Nguyễn Huệ, Thành phố Đà Nẵng, Tỉnh Đà Nẵng',22),
('Phạm Duy Khang','3988995037' ,'1981-03-29' , 1, '4531598141',10000000 ,'30, Đường Nguyễn Thị Minh Khai, Thành phố Hồ Chí Minh',23),
('Trần Ngọc Ðào','5189553080' , '1981-08-22', 0,'6499844443' , 11000000,'5, Đường Trần Hưng Đạo, Thành phố Cần Thơ, Tỉnh Cần Thơ',24),
('Mã Hữu Phước', '6172438332', '1990-09-22', 1, '5345490853',12000000 ,'12, Đường Nguyễn Công Trứ, Thành phố Huế, Tỉnh Thừa Thiên Huế',25),
('Giàng A Phò', '9869095473', '1977-08-08', 1,'1852312064' ,9000000 ,'8, Đường Ngô Gia Tự, Thành phố Hải Dương, Tỉnh Hải Dương',26),
('Trương Anh Ngọk','5184836047','1981-02-13' ,1 , '3443457079',9000000 ,'20, Đường Lê Lợi, Thành phố Nha Trang, Tỉnh Khánh Hòa',27);

-- dữ liệu bảng qualification
insert into `qualifications`(`qualification_name`, `qualification_fee`,`course_duration`, `qualification_description`) 
values 
('B2',15000000,3,'ĐÂY LÀ MÔ TẢ VỀ BẰNG LÁI XE B2'),
('C',16000000,6,'ĐÂY LÀ MÔ TẢ VỀ BẰNG LÁI XE B2'),
('D',18000000,7,'ĐÂY LÀ MÔ TẢ VỀ BẰNG LÁI XE B2');

-- disable Account
DELIMITER //
CREATE PROCEDURE disableAccount(
    IN id_account INT
)
BEGIN
    UPDATE account
    SET account_status = false
    WHERE id = id_account;
	DELETE FROM user_role
    WHERE account_id = id_account;
END;
//
DELIMITER ;
-- hàm thêm mới account
DELIMITER //
CREATE PROCEDURE add_account(
  IN p_email VARCHAR(255),
  IN p_password VARCHAR(255),
  IN p_status BIT,
  IN p_role INT
)
BEGIN
  INSERT INTO account (account_email, account_password, account_status)
  VALUES (p_email, p_password, p_status);
  INSERT INTO user_role (role_id, account_id)
  VALUES (p_role, LAST_INSERT_ID());
END;
//
DELIMITER ;
DELIMITER //
CREATE PROCEDURE add_user(
  IN p_email VARCHAR(255),
  IN p_password VARCHAR(255),
  IN p_status BIT
)
BEGIN
  INSERT INTO account (account_email, account_password, account_status)
  VALUES (p_email, p_password, p_status);
  INSERT INTO user_role (role_id, account_id)
  VALUES (3, LAST_INSERT_ID());
END;
//





