-- 코드를 작성해주세요
# select A.PARNET_ITEM_ID from (select ifnull(PARENT_ITEM_ID,ITEM_ID) as PARNET_ITEM_ID from ITEM_TREE) as A group by A.PARNET_ITEM_ID
# select ITEM_ID,ITEM_NAME,RARITY from ITEM_INFO where ITEM_ID not 
# in (select A.PARNET_ITEM_ID from (select ifnull(PARENT_ITEM_ID,ITEM_ID) as PARNET_ITEM_ID from ITEM_TREE) as A group by A.PARNET_ITEM_ID)
# order by ITEM_ID DESC

select ITEM_ID,ITEM_NAME,RARITY from ITEM_INFO where ITEM_ID not 
in (select distinct PARENT_ITEM_ID FROM ITEM_TREE where PARENT_ITEM_ID is not null)
order by ITEM_ID DESC