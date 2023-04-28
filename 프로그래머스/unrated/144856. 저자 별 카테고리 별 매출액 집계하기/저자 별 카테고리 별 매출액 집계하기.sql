with 
total_sales_table as(select book_id,sum(sales) as total_cnt
from book_sales
where month(sales_date)=01 and year(sales_date)=2022
group by book_id)

select author.author_id,author.author_name,book_and_sales.category,sum(book_and_sales.total_sales) as total_sales
from (select b.category,b.author_id, total_cnt*price as total_sales
from total_sales_table t, book b
where t.book_id=b.book_id) book_and_sales, author 
where book_and_sales.author_id=author.author_id
group by author_id,category
order by 1 asc, 3 desc