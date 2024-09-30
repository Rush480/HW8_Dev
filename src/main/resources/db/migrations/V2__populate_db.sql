INSERT INTO worker (name, birthday, level, salary)
VALUES ('John Doe', '1985-02-15', 'Senior', 6000),
       ('Jane Smith', '1990-07-25', 'Middle', 4500),
       ('Alice Johnson', '1992-03-17', 'Junior', 2500),
       ('Robert Brown', '1995-08-23', 'Trainee', 900),
       ('Michael Davis', '1988-12-11', 'Senior', 7000),
       ('Emily Wilson', '1993-04-05', 'Middle', 4700),
       ('James Taylor', '1996-11-13', 'Junior', 2800),
       ('Patricia Anderson', '1998-06-07', 'Trainee', 850),
       ('Linda Thomas', '1980-09-30', 'Senior', 8000),
       ('David Moore', '1994-01-19', 'Middle', 5000);

INSERT INTO client (name)
VALUES ('Client A'),
       ('Client B'),
       ('Client C'),
       ('Client D'),
       ('Client E');

INSERT INTO project (client_id, start_date, finish_date)
VALUES (1, '2023-01-01', '2023-12-31'),
       (2, '2022-06-01', '2024-06-01'),
       (3, '2021-01-01', '2022-12-31'),
       (4, '2023-07-01', '2023-09-30'),
       (5, '2020-03-01', '2023-03-01'),
       (1, '2024-01-01', '2024-07-01'),
       (3, '2023-10-01', '2024-03-01'),
       (4, '2022-02-01', '2022-12-01'),
       (2, '2021-11-01', '2022-10-31'),
       (5, '2019-01-01', '2023-01-01');


INSERT INTO project_worker (project_id, worker_id)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (2, 4),
       (2, 5),
       (3, 6),
       (3, 7),
       (3, 8),
       (4, 9),
       (5, 10),
       (5, 1),
       (6, 2),
       (6, 3),
       (7, 4),
       (7, 5),
       (8, 6),
       (8, 7),
       (9, 8),
       (9, 9),
       (10, 10);
