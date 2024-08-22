-- 코드를 입력하세요
SELECT REST_info.REST_ID, REST_NAME, FOOD_TYPE, FAVORITES,ADDRESS,A.SCORE from Rest_info join (select REST_ID,round(avg(REVIEW_SCORE),2) as score from REST_REVIEW group by REST_ID) as A on REST_info.REST_ID = A.REST_ID 
WHERE ADDRESS like '서울%'
order by A.SCORE DESC, FAVORITES DESC
;