-- 코드를 입력하세요
-- SELECT user_id,count(product_id) FROM ONLINE_SALE group by user_id
select user_id,product_id 
    from online_sale 
    group by user_id,product_id 
    having count(product_id) > 1 
    order by user_id, product_id desc