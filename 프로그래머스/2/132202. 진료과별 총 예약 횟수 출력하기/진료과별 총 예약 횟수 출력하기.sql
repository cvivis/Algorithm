-- 코드를 입력하세요
SELECT DATE_FORMAT(APNT_YMD,"%Y-%m") FROM APPOINTMENT ;
SELECT MCDP_CD as '진료과 코드' , count(PT_NO) as '5월예약건수' FROM APPOINTMENT 
where DATE_FORMAT(APNT_YMD,"%Y-%m") = '2022-05' group by MCDP_CD
order by count(PT_NO) ASC ,  MCDP_CD ASC
# SELECT MCDP_CD as '진료과 코드' FROM APPOINTMENT 
# where DATE_FORMAT(APNT_YMD,"%Y-%m") = '2022-05'
# ;