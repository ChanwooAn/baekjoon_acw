select date_format(b.sales_date,"%Y") as Year,
date_format(b.sales_date,"%m") as month,
a.gender,
count(distinct a.user_id) as users
from
(select * from user_info where gender is not null) a,
online_sale b
where a.user_id=b.user_id and a.gender is not null
group by year,month,gender
order by 1,2,3