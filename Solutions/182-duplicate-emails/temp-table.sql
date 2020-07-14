-- Every derived table must have its own alias

SELECT email FROM 
(
    SELECT Email, COUNT(Email) num
    FROM Person
    GROUP BY Email
) AS statistic
WHERE num > 1;