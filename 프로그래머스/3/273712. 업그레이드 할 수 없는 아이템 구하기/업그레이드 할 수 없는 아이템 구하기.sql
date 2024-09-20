-- 코드를 작성해주세요
# select PARENT_ITEM_ID from ITEM_TREE group by PARENT_ITEM_ID
select ITEM_ID,ITEM_NAME,RARITY from ITEM_INFO where ITEM_ID not in (select ifnull(PARENT_ITEM_ID,ITEM_ID) from ITEM_TREE group by PARENT_ITEM_ID)
order by ITEM_ID DESC