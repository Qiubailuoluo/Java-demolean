-- JavaLean 表结构
-- 执行：mysql -u root -p javalean < database/02-schema.sql

USE javalean;

-- 用户
CREATE TABLE IF NOT EXISTS t_user (
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    username    VARCHAR(50)  NOT NULL UNIQUE,
    email       VARCHAR(100) NOT NULL,
    age         INT          NOT NULL DEFAULT 0,
    status      TINYINT      NOT NULL DEFAULT 1 COMMENT '1启用 0禁用',
    created_at  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB COMMENT='用户';

-- 商品分类
CREATE TABLE IF NOT EXISTS t_category (
    id          INT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(50) NOT NULL,
    parent_id   INT DEFAULT NULL,
    sort_order  INT NOT NULL DEFAULT 0
) ENGINE=InnoDB COMMENT='分类';

-- 商品
CREATE TABLE IF NOT EXISTS t_product (
    id            BIGINT PRIMARY KEY AUTO_INCREMENT,
    category_id   INT          NOT NULL,
    name          VARCHAR(100) NOT NULL,
    price         DECIMAL(10,2) NOT NULL,
    stock         INT          NOT NULL DEFAULT 0,
    created_at    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_product_category FOREIGN KEY (category_id) REFERENCES t_category(id)
) ENGINE=InnoDB COMMENT='商品';

-- 订单主表
CREATE TABLE IF NOT EXISTS t_order (
    id           BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id      BIGINT       NOT NULL,
    order_no     VARCHAR(32)  NOT NULL UNIQUE,
    total_amount DECIMAL(12,2) NOT NULL DEFAULT 0,
    status       VARCHAR(20)  NOT NULL DEFAULT 'CREATED' COMMENT 'CREATED/PAID/CANCELLED',
    created_at   DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_order_user FOREIGN KEY (user_id) REFERENCES t_user(id)
) ENGINE=InnoDB COMMENT='订单';

-- 订单明细
CREATE TABLE IF NOT EXISTS t_order_item (
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    order_id    BIGINT       NOT NULL,
    product_id  BIGINT       NOT NULL,
    quantity    INT          NOT NULL,
    unit_price  DECIMAL(10,2) NOT NULL,
    CONSTRAINT fk_item_order FOREIGN KEY (order_id) REFERENCES t_order(id),
    CONSTRAINT fk_item_product FOREIGN KEY (product_id) REFERENCES t_product(id)
) ENGINE=InnoDB COMMENT='订单明细';

-- 账户（转账事务练习）
CREATE TABLE IF NOT EXISTS t_account (
    id        BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id   BIGINT         NOT NULL UNIQUE,
    balance   DECIMAL(12,2)  NOT NULL DEFAULT 0,
    CONSTRAINT fk_account_user FOREIGN KEY (user_id) REFERENCES t_user(id)
) ENGINE=InnoDB COMMENT='账户余额';

-- 学生 / 课程 / 选课（多对多）
CREATE TABLE IF NOT EXISTS t_student (
    id      INT PRIMARY KEY AUTO_INCREMENT,
    name    VARCHAR(50) NOT NULL,
    major   VARCHAR(50) NOT NULL
) ENGINE=InnoDB COMMENT='学生';

CREATE TABLE IF NOT EXISTS t_course (
    id      INT PRIMARY KEY AUTO_INCREMENT,
    name    VARCHAR(80) NOT NULL,
    credit  INT NOT NULL DEFAULT 2
) ENGINE=InnoDB COMMENT='课程';

CREATE TABLE IF NOT EXISTS t_enrollment (
    student_id INT NOT NULL,
    course_id  INT NOT NULL,
    score      DECIMAL(5,2) DEFAULT NULL,
    PRIMARY KEY (student_id, course_id),
    CONSTRAINT fk_enr_student FOREIGN KEY (student_id) REFERENCES t_student(id),
    CONSTRAINT fk_enr_course FOREIGN KEY (course_id) REFERENCES t_course(id)
) ENGINE=InnoDB COMMENT='选课';
