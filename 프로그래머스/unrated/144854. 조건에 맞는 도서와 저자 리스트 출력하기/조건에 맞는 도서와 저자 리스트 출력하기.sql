SELECT b.book_id, a.author_name, date_format(b.published_date,'%Y-%m-%d') as published_date
from book b, author a
where category='경제' and b.author_id=a.author_id
order by published_date asc