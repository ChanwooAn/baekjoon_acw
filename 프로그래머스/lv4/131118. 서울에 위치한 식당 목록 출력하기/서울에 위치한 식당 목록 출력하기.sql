with 
seoul_rest as
(select * 
 from rest_info
 where address like "서울%")
 /*
 
 */
 select s.rest_id,s.rest_name,s.food_type,s.favorites,s.address,round(avg(r.review_score),2) as score
 from seoul_rest s, rest_review r
 where s.rest_id=r.rest_id
 group by s.rest_id
 order by score desc, favorites desc
