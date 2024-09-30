CREATE TABLE worker
(
    id       SERIAL PRIMARY KEY,
    name     VARCHAR(1000) NOT NULL CHECK (LENGTH(name) BETWEEN 2 AND 1000),
    birthday DATE CHECK (EXTRACT(YEAR FROM birthday) > 1900),
    level    VARCHAR(10)   NOT NULL CHECK (level IN ('Trainee', 'Junior', 'Middle', 'Senior')),
    salary   INTEGER CHECK (salary BETWEEN 100 AND 100000)
);


CREATE TABLE client
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(1000) NOT NULL CHECK (LENGTH(name) BETWEEN 2 AND 1000)
);


CREATE TABLE project
(
    id          SERIAL PRIMARY KEY,
    client_id   INTEGER REFERENCES client (id) ON DELETE CASCADE,
    start_date  DATE,
    finish_date DATE
);


CREATE TABLE project_worker
(
    project_id INTEGER REFERENCES project (id) ON DELETE CASCADE,
    worker_id  INTEGER REFERENCES worker (id) ON DELETE CASCADE,
    PRIMARY KEY (project_id, worker_id)
);
