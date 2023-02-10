with
f as (SELECT flavor, sum(total_order) s
from first_half
group by flavor)
,
j as (SELECT flavor, sum(total_order) s
from july
group by flavor)

select flavor
from(select *
    from f
    union
    select* 
    from j
         ) t
group by flavor
order by sum(s) desc
limit 3

