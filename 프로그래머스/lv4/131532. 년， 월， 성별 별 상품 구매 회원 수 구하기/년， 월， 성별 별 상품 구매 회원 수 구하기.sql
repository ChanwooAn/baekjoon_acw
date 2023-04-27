select year(b.sales_date) as Year,
month(b.sales_date) as month,
a.gender,
count(distinct a.user_id) as users
from
(select * from user_info where gender is not null) a,
online_sale b
where a.user_id=b.user_id and a.gender is not null
group by year,month,gender
order by 1,2,3