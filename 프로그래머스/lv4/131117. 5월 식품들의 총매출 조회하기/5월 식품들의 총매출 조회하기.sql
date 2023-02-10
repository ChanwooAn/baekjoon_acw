SELECT p.product_id,p.product_name,sum(o.amount)*p.price as total_sales
from food_product p, food_order o
where p.product_id=o.product_id and year(o.produce_date)='2022' and month(o.produce_date)='05'
group by product_id
order by total_sales desc, p.product_id asc
