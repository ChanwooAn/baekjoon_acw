select car_id,average_duration
from (select car_id,round(avg(datediff(end_date,start_date)+1),1) as average_duration
from car_rental_company_rental_history
group by car_id) t
where average_duration>6
order by 2 desc, car_id desc