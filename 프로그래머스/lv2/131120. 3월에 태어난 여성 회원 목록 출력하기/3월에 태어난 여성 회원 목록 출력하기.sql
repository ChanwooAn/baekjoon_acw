

SELECT member_id, member_name,gender,Date_format(date_of_birth,'%Y-%m-%d') as date_of_birth
from member_profile
where tlno is not null and month(date_of_birth)=3 and gender='w'
order by member_id asc