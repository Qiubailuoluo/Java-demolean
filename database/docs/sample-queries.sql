-- javalean 常用练习查询（在 Navicat 或 mysql 客户端中分段执行）
USE javalean;

-- ---------- 1. 基础查询 ----------
-- 所有启用用户
SELECT id, username, email, age FROM t_user WHERE status = 1;

-- 价格高于 100 的商品
SELECT id, name, price, stock FROM t_product WHERE price > 100 ORDER BY price DESC;

-- ---------- 2. 关联查询 ----------
-- 订单 + 用户名
SELECT o.order_no, o.total_amount, o.status, u.username
FROM t_order o
JOIN t_user u ON o.user_id = u.id;

-- 订单明细 + 商品名
SELECT o.order_no, p.name AS product_name, i.quantity, i.unit_price
FROM t_order_item i
JOIN t_order o ON i.order_id = o.id
JOIN t_product p ON i.product_id = p.id;

-- ---------- 3. 聚合 ----------
-- 每名学生已出分课程的平均分
SELECT s.name, AVG(e.score) AS avg_score
FROM t_student s
JOIN t_enrollment e ON s.id = e.student_id
WHERE e.score IS NOT NULL
GROUP BY s.id, s.name;

-- 各分类下商品数量
SELECT c.name AS category_name, COUNT(p.id) AS product_count
FROM t_category c
LEFT JOIN t_product p ON c.id = p.category_id
GROUP BY c.id, c.name;

-- ---------- 4. 子查询 ----------
-- 余额最高的账户对应用户
SELECT u.username, a.balance
FROM t_account a
JOIN t_user u ON a.user_id = u.id
WHERE a.balance = (SELECT MAX(balance) FROM t_account);

-- ---------- 5. 自练扩展（自行完成） ----------
-- TODO: 查询选修了「Java 程序设计」的学生姓名
-- TODO: 统计 PAID 状态订单总金额
-- TODO: 查询库存小于 10 的商品列表
