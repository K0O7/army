INSERT INTO Army.soldiers VALUES (1, 'John', 'Doe');
INSERT INTO Army.soldiers VALUES (2, 'Jane', 'Smith');
INSERT INTO Army.soldiers VALUES (3, 'Alex', 'Taylor');
INSERT INTO Army.soldiers VALUES (4, 'Chris', 'Brown');
INSERT INTO Army.soldiers VALUES (5, 'Pat', 'White');

INSERT INTO Army.training_programs VALUES (1, 'Basic Training');
INSERT INTO Army.training_programs VALUES (2, 'Advanced Combat Training');
INSERT INTO Army.training_programs VALUES (3, 'Field Medical Training');
INSERT INTO Army.training_programs VALUES (4, 'Weapons Handling');
INSERT INTO Army.training_programs VALUES (5, 'Leadership Training');

INSERT INTO Army.soldier_training VALUES (1, 1, 1, '2025-01-01', '2025-01-15');
INSERT INTO Army.soldier_training VALUES (2, 2, 2, '2025-01-10', '2025-01-25');
INSERT INTO Army.soldier_training VALUES (3, 3, 3, '2025-01-05', NULL);
INSERT INTO Army.soldier_training VALUES (4, 4, 4, '2025-01-12', '2025-01-20');
INSERT INTO Army.soldier_training VALUES (5, 5, 5, '2025-01-02', '2025-01-30');

INSERT INTO Army.mediacal_records VALUES (1, 'A', 1, 1);
INSERT INTO Army.mediacal_records VALUES (2, 'B', 0, 2);
INSERT INTO Army.mediacal_records VALUES (3, 'O', 1, 3);
INSERT INTO Army.mediacal_records VALUES (4, 'AB', 0, 4);
INSERT INTO Army.mediacal_records VALUES (5, 'O', 1, 5);

INSERT INTO Army.allergies VALUES (1, 'Peanuts', 1);
INSERT INTO Army.allergies VALUES (2, 'Dust', 2);
INSERT INTO Army.allergies VALUES (3, 'Pollen', 3);
INSERT INTO Army.allergies VALUES (4, 'Milk', 4);
INSERT INTO Army.allergies VALUES (5, 'Shellfish', 5);

INSERT INTO Army.ranks VALUES (1, 'Private', 1);
INSERT INTO Army.ranks VALUES (2, 'Sergeant', 2);
INSERT INTO Army.ranks VALUES (3, 'Lieutenant', 3);
INSERT INTO Army.ranks VALUES (4, 'Captain', 4);
INSERT INTO Army.ranks VALUES (5, 'Major', 5);

INSERT INTO Army.units VALUES (1, 'Infantry');
INSERT INTO Army.units VALUES (2, 'Armored');
INSERT INTO Army.units VALUES (3, 'Medical');
INSERT INTO Army.units VALUES (4, 'Logistics');
INSERT INTO Army.units VALUES (5, 'Reconnaissance');

INSERT INTO Army.divisions VALUES (1, 'Alpha Division', 1, 1);
INSERT INTO Army.divisions VALUES (2, 'Bravo Division', 2, 2);
INSERT INTO Army.divisions VALUES (3, 'Charlie Division', 3, 3);
INSERT INTO Army.divisions VALUES (4, 'Delta Division', 4, 4);
INSERT INTO Army.divisions VALUES (5, 'Echo Division', 5, 5);

INSERT INTO Army.departments VALUES (1, 'Logistics', 1);
INSERT INTO Army.departments VALUES (2, 'Engineering', 2);
INSERT INTO Army.departments VALUES (3, 'Medical', 3);
INSERT INTO Army.departments VALUES (4, 'Communications', 4);
INSERT INTO Army.departments VALUES (5, 'Weapons', 5);

INSERT INTO Army.missions (id, mission_name, mission_date, location) VALUES
(1, 'Recon Mission', '2024-03-01', 'Mountain Region'),
(2, 'Training Exercise', '2024-03-15', 'Desert Base'),
(3, 'Rescue Operation', '2024-03-20', 'Jungle Outpost'),
(4, 'Urban Drill', '2024-03-25', 'City Center'),
(5, 'Night Ops', '2024-03-30', 'Forest Area');

INSERT INTO Army.equipment (id, equipment_name, equipment_type) VALUES
(1, 'Rifle', 'Weapon'),
(2, 'Binoculars', 'Optical'),
(3, 'Radio', 'Communication'),
(4, 'Helmet', 'Protective'),
(5, 'Night Vision Goggles', 'Optical');

INSERT INTO Army.unit_missions (id, missions_id, units_id) VALUES
('UM1', 1, 1),
('UM2', 2, 2),
('UM3', 3, 3),
('UM4', 4, 4),
('UM5', 5, 5);

INSERT INTO Army.soldier_equipment (id, equipment_id, soldiers_id, issue_date, return_date) VALUES
(1, 1, 1, '2024-01-15', NULL),
(2, 2, 2, '2024-01-20', '2024-02-10'),
(3, 3, 3, '2024-01-25', '2024-02-15'),
(4, 4, 4, '2024-02-01', NULL),
(5, 5, 5, '2024-02-10', NULL);
