SELECT category, sum(sales) as total_sales
from book, book_sales
where book.book_id=book_sales.book_id
and date_format(sales_date,"%Y-%m")='2022-01'
group by category
order by category asc