SELECT COUNT(*) AS total_soldiers FROM Army.soldiers;
SELECT AVG(id) AS avg_rank_id FROM Army.ranks;
SELECT MAX(id) AS max_unit_id FROM Army.units;
SELECT MIN(id) AS min_training_id FROM Army.training_programs;
SELECT SUM(id) AS total_equipment_id FROM Army.equipment;
SELECT unit_name, COUNT(*) AS unit_count FROM Army.units GROUP BY unit_name;
SELECT blood_type, COUNT(*) AS total_soldiers FROM Army.mediacal_records GROUP BY blood_type;
