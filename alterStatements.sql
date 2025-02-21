ALTER TABLE Army.soldiers ADD COLUMN middle_name VARCHAR(45) AFTER first_name;
ALTER TABLE Army.training_programs MODIFY COLUMN program_name VARCHAR(100);
ALTER TABLE Army.divisions ADD COLUMN division_code VARCHAR(10);
ALTER TABLE Army.equipment DROP COLUMN equipment_type;
ALTER TABLE Army.ranks RENAME COLUMN rank_name TO `designation`;