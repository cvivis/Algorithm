-- 코드를 입력하세요
SELECT ANIMAL_TYPE,count(ANIMAL_ID) as count FROM ANIMAL_INS where ANIMAL_TYPE in ("Cat","Dog") group by ANIMAL_TYPE order by ANIMAL_TYPE ASC;
# select count(ANIMAL_ID) FROM ANIMAL_INS where ANIMAL_TYPE = "Dog"