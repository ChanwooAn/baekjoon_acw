select flavor
from (
    select * from first_half
    union
    select * from july) as tmp
group by flavor
order by sum(total_order) desc
limit 3