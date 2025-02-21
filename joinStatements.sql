SELECT * 
FROM Army.soldiers
INNER JOIN Army.ranks ON soldiers.id = ranks.soldiers_id;

SELECT * 
FROM Army.soldiers 
LEFT JOIN Army.mediacal_records ON soldiers.id = mediacal_records.soldiers_id;

SELECT * 
FROM Army.divisions 
RIGHT JOIN Army.departments ON divisions.id = departments.divisions_id;

SELECT * 
FROM Army.soldiers 
LEFT JOIN Army.ranks ON soldiers.id = ranks.soldiers_id
UNION
SELECT * 
FROM Army.soldiers
RIGHT JOIN Army.ranks ON soldiers.id = ranks.soldiers_id;

SELECT * 
FROM Army.soldiers 
JOIN Army.soldier_training ON soldiers.id = soldier_training.soldiers_id
WHERE soldier_training.start_date >= '2025-01-01';
