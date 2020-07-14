-- select from a temp table in order to return null
-- use DISTINCT to avoid turning duplicate highest number

SELECT (
    SELECT DISTINCT salary
    FROM employee
    ORDER BY salary DESC
    LIMIT 1 OFFSET 1
) SecondHighestSalary