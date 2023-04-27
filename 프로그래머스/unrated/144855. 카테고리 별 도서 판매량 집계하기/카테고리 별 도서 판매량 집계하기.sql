select book.category,sum(sale.total_sales) as total_sales
from
(select book_id,sum(sales) as total_sales
from book_sales
where date_format(sales_date,'%m')=01
group by book_id
) sale, book
where sale.book_id=book.book_id
group by 1
order by 1 
