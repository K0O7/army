SELECT unit_name, COUNT(*) AS unit_count 
FROM Army.units 
GROUP BY unit_name 
HAVING unit_count > 1;

SELECT designation, AVG(id) AS avg_rank_id 
FROM Army.ranks 
GROUP BY designation 
HAVING avg_rank_id < 3;

SELECT department_name, MAX(id) AS max_dept_id 
FROM Army.departments 
GROUP BY department_name 
HAVING max_dept_id > 2;

SELECT training_programs_id, SUM(id) AS total_training_id 
FROM Army.soldier_training 
GROUP BY training_programs_id 
HAVING total_training_id > 10;

SELECT blood_type, COUNT(*) AS count 
FROM Army.mediacal_records 
GROUP BY blood_type 
HAVING count > 1;

SELECT division_name, COUNT(*) AS count 
FROM Army.divisions 
GROUP BY division_name 
HAVING count > 2;

SELECT equipment_name, COUNT(*) AS count 
FROM Army.equipment 
GROUP BY equipment_name 
HAVING count > 3;
