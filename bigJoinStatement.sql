SELECT *
FROM Army.soldiers
JOIN Army.mediacal_records ON soldiers.id = mediacal_records.soldiers_id
JOIN Army.ranks ON soldiers.id = ranks.soldiers_id
JOIN Army.divisions ON soldiers.id = divisions.soldiers_id
JOIN Army.departments ON divisions.id = departments.divisions_id
JOIN Army.soldier_training ON soldiers.id = soldier_training.soldiers_id
JOIN Army.training_programs ON soldier_training.training_programs_id = training_programs.id
JOIN Army.allergies ON mediacal_records.id = allergies.mediacal_records_id;
