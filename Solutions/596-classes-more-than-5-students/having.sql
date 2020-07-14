-- there could be duplicated records
-- use distinct to exclude duplicated records

SELECT class 
FROM courses
GROUP BY class
HAVING COUNT(DISTINCT student) >= 5