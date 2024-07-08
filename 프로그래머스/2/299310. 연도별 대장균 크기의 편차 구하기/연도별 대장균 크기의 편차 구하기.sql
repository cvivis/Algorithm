-- 코드를 작성해주세요
select year(E.DIFFERENTIATION_DATE) as YEAR , (B.size - E.SIZE_OF_COLONY) as YEAR_DEV , ID from ECOLI_DATA as E join 
(select date,MAX(SIZE_OF_COLONY) as size From (select SIZE_OF_COLONY,ID, year(DIFFERENTIATION_DATE) as date from ECOLI_DATA) as A
group by date) as B
on year(E.DIFFERENTIATION_DATE) = B.date
order by B.date asc , YEAR_DEV ASC