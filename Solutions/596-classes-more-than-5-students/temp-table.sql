SELECT class
FROM (
    SELECT class, COUNT(DISTINCT student) as num
    FROM courses
    GROUP BY class
) AS temp
WHERE num >= 5