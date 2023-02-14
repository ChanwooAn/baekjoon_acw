with 
t as
(SELECT food_type,max(favorites) as cnt
from rest_info
group by food_type
) 

select t.food_type, rest_id,rest_name,favorites
from rest_info r, t
where r.food_type=t.food_type and r.favorites=t.cnt
order by food_type desc