

SELECT A.ANIMAL_ID, A.ANIMAL_TYPE, A.NAME  
FROM ANIMAL_INS A
    ,ANIMAL_OUTS B
WHERE A.ANIMAL_ID = B.ANIMAL_ID AND SEX_UPON_INTAKE != SEX_UPON_OUTCOME