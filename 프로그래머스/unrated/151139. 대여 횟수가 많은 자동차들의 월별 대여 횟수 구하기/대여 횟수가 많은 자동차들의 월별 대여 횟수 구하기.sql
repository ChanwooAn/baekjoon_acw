with 
targetHistory as(SELECT *
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where year(start_date)=2022 and month(start_date) between 8 and 10
-- 8월 부터 10월까지의 기록만 뽑은 table만들기                 
) 
,
targetCar_id as(select count(*) as cnt, car_id
from targetHistory
group by car_id
having cnt>4
-- 5회 이상인 자동차 번호 뽑기
)
    
select month(h.start_date) as month,  c.car_id, count(*) as records
from targetHistory h, targetCar_id c
where h.car_id=c.car_id
group by month(h.start_date), car_id
having records!=0
order by 1 asc, 2 desc