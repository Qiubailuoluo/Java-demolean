-- JavaLean 初始练习数据
-- 执行：mysql -u root -p javalean < database/03-seed-data.sql

USE javalean;

-- 用户
INSERT INTO t_user (username, email, age, status) VALUES
('alice',   'alice@javalean.local',   22, 1),
('bob',     'bob@javalean.local',     25, 1),
('charlie', 'charlie@javalean.local', 30, 1),
('diana',   'diana@javalean.local',   28, 0);

-- 分类
INSERT INTO t_category (id, name, parent_id, sort_order) VALUES
(1, '图书', NULL, 1),
(2, '电子产品', NULL, 2),
(3, 'Java', 1, 1),
(4, 'Spring', 1, 2);

-- 商品
INSERT INTO t_product (category_id, name, price, stock) VALUES
(3, 'Java 编程思想', 88.00, 50),
(3, 'Effective Java', 69.00, 30),
(4, 'Spring 实战', 79.00, 40),
(2, '机械键盘', 299.00, 10),
(2, '显示器', 1299.00, 5);

-- 账户
INSERT INTO t_account (user_id, balance) VALUES
(1, 1000.00),
(2, 500.50),
(3, 2000.00);

-- 订单 + 明细
INSERT INTO t_order (user_id, order_no, total_amount, status) VALUES
(1, 'ORD20260101001', 167.00, 'PAID'),
(2, 'ORD20260101002', 299.00, 'CREATED');

INSERT INTO t_order_item (order_id, product_id, quantity, unit_price) VALUES
(1, 1, 1, 88.00),
(1, 2, 1, 69.00),
(1, 3, 1, 79.00),
(2, 4, 1, 299.00);

-- 学生 / 课程 / 选课
INSERT INTO t_student (name, major) VALUES
('张三', '计算机'),
('李四', '软件工程'),
('王五', '计算机');

INSERT INTO t_course (name, credit) VALUES
('Java 程序设计', 3),
('数据库原理', 3),
('Spring Boot 开发', 2);

INSERT INTO t_enrollment (student_id, course_id, score) VALUES
(1, 1, 92.5),
(1, 2, 88.0),
(2, 1, 76.0),
(2, 3, NULL),
(3, 2, 95.0);
