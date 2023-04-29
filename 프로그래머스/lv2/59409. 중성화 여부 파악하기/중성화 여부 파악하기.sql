select animal_id,name,
case when sex_upon_intake like "Neuter%" or sex_upon_intake like "spayed%" then 'O'
else 'X' 
end
as 중성화

from animal_ins
order by 1