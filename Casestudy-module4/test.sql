create database module4_test_data_2;
use module4_test_data_2;

-- qualification--
CREATE TABLE qualifications (
    id INT PRIMARY KEY AUTO_INCREMENT,
    qualification_name VARCHAR(30),
    qualification_fee BIGINT,
    course_duration INT,
    qualification_description LONGTEXT,
    is_deleted BIT DEFAULT 0
);

-- ----dữ liệu bảng role---------
INSERT INTO `role` (`id`, `role_name`) VALUES (1, 'ROLE_ADMIN');
INSERT INTO `role` (`id`, `role_name`) VALUES (2, 'ROLE_TEACHER');
INSERT INTO `role` (`id`, `role_name`) VALUES (3, 'ROLE_STUDENT');
-- dữ liệu bảng account--
INSERT INTO `account` (`id`, `account_email`, `account_password`, `account_status`) VALUES (1, 'ductrung@gmail.com', '$2a$12$uq6nSrlrVpyGh0OFenhFcO1pB56/IxItRrSrl7HD3GP2VpWeNfx.G', 1);
INSERT INTO `account` (`id`, `account_email`, `account_password`, `account_status`) VALUES (2, 'baothien@gmail.com', '$2a$12$0MqW79HquXxAnYwQtABedeCTIXzYNWrPfTvCMnUxvPYG9FcMPGhda', 1);
INSERT INTO `account` (`id`, `account_email`, `account_password`, `account_status`) VALUES (3, 'myhanh@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', 1);
INSERT INTO `account` (`id`, `account_email`, `account_password`, `account_status`) VALUES (4, 'quocsang@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', 1);
INSERT INTO `account` (`id`, `account_email`, `account_password`, `account_status`) VALUES (5, 'xuannghiag@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', 1);
INSERT INTO `account` (`id`, `account_email`, `account_password`, `account_status`) VALUES (6, 'thihao@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', 1);
INSERT INTO `account` (`id`, `account_email`, `account_password`, `account_status`) VALUES (7, 'mykim@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', 1);
INSERT INTO `account` (`id`, `account_email`, `account_password`, `account_status`) VALUES (8, 'vanquan@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', 1);
INSERT INTO `account` (`id`, `account_email`, `account_password`, `account_status`) VALUES (9, 'ducthao@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', 1);
INSERT INTO `account` (`id`, `account_email`, `account_password`, `account_status`) VALUES (10, 'mocchau@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', 1);
INSERT INTO `account` (`id`, `account_email`, `account_password`, `account_status`) VALUES (11, 'hongquang@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', 1);
INSERT INTO `account` (`id`, `account_email`, `account_password`, `account_status`) VALUES (12, 'hoangvinh@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', 1);
INSERT INTO `account` (`id`, `account_email`, `account_password`, `account_status`) VALUES (13, 'thilinh@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', 1);
INSERT INTO `account` (`id`, `account_email`, `account_password`, `account_status`) VALUES (14, 'daidanh@gmail.com', '$2a$12$2z8MKSD4noar1d5zQHWgfeiIaBwdkRA7A33LKREJO.KUJXFS/3lxe', 1);
-- dữ liệu bảng user_role-----
INSERT INTO `user_role` (`id`, `account_id`, `role_id`) VALUES (1, 1, 1);
INSERT INTO `user_role` (`id`, `account_id`, `role_id`) VALUES (2, 2, 1);
INSERT INTO `user_role` (`id`, `account_id`, `role_id`) VALUES (3, 3, 1);
INSERT INTO `user_role` (`id`, `account_id`, `role_id`) VALUES (4, 4, 1);
INSERT INTO `user_role` (`id`, `account_id`, `role_id`) VALUES (5, 5, 2);
INSERT INTO `user_role` (`id`, `account_id`, `role_id`) VALUES (6, 6, 2);
INSERT INTO `user_role` (`id`, `account_id`, `role_id`) VALUES (7, 7, 2);
INSERT INTO `user_role` (`id`, `account_id`, `role_id`) VALUES (8, 8, 2);
INSERT INTO `user_role` (`id`, `account_id`, `role_id`) VALUES (9, 9, 2);
INSERT INTO `user_role` (`id`, `account_id`, `role_id`) VALUES (10,10, 3);
INSERT INTO `user_role` (`id`, `account_id`, `role_id`) VALUES (11,11, 3);
INSERT INTO `user_role` (`id`, `account_id`, `role_id`) VALUES (12,12, 3);
INSERT INTO `user_role` (`id`, `account_id`, `role_id`) VALUES (13,13, 3);
INSERT INTO `user_role` (`id`, `account_id`, `role_id`) VALUES (14,14, 3);
-- -----dữ liệu bảng classes----
insert into `classes` (`id`,`classes_name`,`status`) values(1,'K01-B2',1);
insert into `classes` (`id`,`classes_name`,`status`) values(2,'K01-C1',1);
insert into `classes` (`id`,`classes_name`,`status`) values(3,'K02-B2',1);
insert into `classes` (`id`,`classes_name`,`status`) values(4,'K02-C1',1);
insert into `classes` (`id`,`classes_name`,`status`) values(5,'K03-C1',1);
insert into `classes` (`id`,`classes_name`,`status`) values(6,'K03-D1',1);
-- dữ liệu bảng students----
insert into `students`(`id`,`address`,`birthday`,`gender`,`student_identity`,`student_name`,`student_phone_number`,`student_point`,`student_status`,`account_id`,`classes_id`) values
(1,'280 Phan Thanh','2000-01-16',0,202000001,'Tôn Nữ Mộc Châu','0701123456',80,1,10,1),
(2,'123 Bạch Đằng','2001-11-16',1,202000002,'Phạm Hồng Quang','0701123777',90,1,11,1),
(3,'33 Lê Thanh Nghị','2002-07-26',1,202000003,'Trần Hoàng Vinh','0701124000',70,1,12,2),
(4,'111 Quang Trung','2000-05-11',0,202000004,'Nguyễn Thị Linh','0701124111',86,1,13,2),
(5,'99 Lý Thái Tổ','2003-11-20',1,202000005,'Trần Đại Danh','0701124333',88,1,14,3);
-- dữ liệu bảng teachers----
insert into `teachers` (`id`,`teacher_address`,`teacher_birthday`,`teacher_gender`,`teacher_identity`,`teacher_name`,`teacher_phone_number`,`teacher_salary`,`teacher_status`,`account_id`) values
(1,'123 Dien Bien Phu', '1990-02-12',1,'201000001', 'Nguyen Phan Xuan Nghia','0969980926',2000,1,5),
(2,'467 Nguyen Van Thoai', '1985-02-24',0,'201000002', 'Nguyễn Thị Hào','0456789132',5000,1,6),
(3,'598 Nguyen Van Linh', '1993-12-12',0,'201000003', 'Nguyễn Mỹ Kim','0705005112',3000,1,7),
(4,'789 Ly Thai To', '1995-02-20',1,'201000004', 'Dương Văn Quan','0705558552',1000,1,8),
(5,'23 Nguyễn Hoàng', '1991-06-22',1,'201000005', 'Trần Đức Thảo','070555776',7000,1,9);
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

-- dữ liệu bảng qualification
insert into `qualifications`(`qualification_name`, `qualification_fee`,`course_duration`, `qualification_description`) 
values 
('B2',15000000,3,'ĐÂY LÀ MÔ TẢ VỀ BẰNG LÁI XE B2'),
('C',16000000,6,'ĐÂY LÀ MÔ TẢ VỀ BẰNG LÁI XE B2'),
('D',18000000,7,'ĐÂY LÀ MÔ TẢ VỀ BẰNG LÁI XE B2');

