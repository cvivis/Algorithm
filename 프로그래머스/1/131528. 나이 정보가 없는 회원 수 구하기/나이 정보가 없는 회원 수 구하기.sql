-- 코드를 입력하세요
SELECT count(user_id) as USERS from user_info 
where Age is null group by Age