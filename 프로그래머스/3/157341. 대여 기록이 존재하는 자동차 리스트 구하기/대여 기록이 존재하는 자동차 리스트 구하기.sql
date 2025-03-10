SELECT DISTINCT CAR_ID
FROM CAR_RENTAL_COMPANY_CAR
WHERE CAR_TYPE = '세단' 
AND CAR_ID IN (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE SUBSTR(START_DATE, 6, 2) = 10
)
ORDER BY CAR_ID DESC