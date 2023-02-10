select product_code, sales

from
(SELECT p.product_id, p.product_code, sum(sales_amount)*p.price as sales
from product p, offline_sale o
where p.product_id=o.product_id
group by product_id) j

order by sales desc, product_code asc