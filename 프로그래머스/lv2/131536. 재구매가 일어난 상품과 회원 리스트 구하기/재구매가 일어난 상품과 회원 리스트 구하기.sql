select user_id, product_id
from (SELECT user_id,product_id,count(*) as ct
    from online_sale
    group by user_id,product_id) newT
where ct>1
order by user_id asc, product_id desc