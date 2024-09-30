SELECT
    id,
    EXTRACT(YEAR FROM AGE(finish_date, start_date)) * 12 +
    EXTRACT(MONTH FROM AGE(finish_date, start_date)) AS month_count
FROM
    project
WHERE
    EXTRACT(YEAR FROM AGE(finish_date, start_date)) * 12 +
    EXTRACT(MONTH FROM AGE(finish_date, start_date)) = (
        SELECT MAX(
                       EXTRACT(YEAR FROM AGE(finish_date, start_date)) * 12 +
                       EXTRACT(MONTH FROM AGE(finish_date, start_date))
               )
        FROM project
    );
