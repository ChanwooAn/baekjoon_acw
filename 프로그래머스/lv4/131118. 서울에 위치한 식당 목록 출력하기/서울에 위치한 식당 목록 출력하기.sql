with seoul as(select *
from rest_info
where address like "서울%")

select seoul.rest_id,seoul.rest_name,seoul.food_type, seoul.favorites,
seoul.address,round(avg(rest_review.review_score),2) as score
from rest_review,seoul
where rest_review.rest_id=seoul.rest_id
group by seoul.rest_id
order by score desc, favorites desc
