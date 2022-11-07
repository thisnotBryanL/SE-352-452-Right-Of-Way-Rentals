INSERT INTO customers (id, name) VALUES (0, 'NERM');
INSERT INTO customers (id, name) VALUES (1000, 'admin');


INSERT INTO vehicles (id, available, make, mileage, model, type) VALUES (0, true, 'SEDAN', 300, 'TOYSTER', 'TOYOTA');
INSERT INTO vehicles (id, available, make, mileage, model, type) VALUES (1, FALSE, 'COUPE', 100, 'COUPSTER AMG', 'MERCEDES');
INSERT INTO vehicles (id, available, make, mileage, model, type) VALUES (2, FALSE, 'SUV', 100, 'SUVSTER', 'HONDA');
INSERT INTO vehicles (id, available, make, mileage, model, type) VALUES (3, FALSE, 'MINIVAN', 200000, 'MINIVANSTER', 'SUBARU');
INSERT INTO vehicles (id, available, make, mileage, model, type) VALUES (4, FALSE, 'SPORT', 2000, 'SPORTSTER M', 'BMW');

INSERT INTO reservations (id, dropoff_time, dropoff_mileage, pickup_time, pickup_mileage, status, customer_id, vehicle_id) VALUES (0, '2022-10-25 06:22:25.163000', 300, '2022-10-25 06:22:25.163000', 300, 'RESERVED', 0, 0);


