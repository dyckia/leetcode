-- use IFNULL() to return null
-- use DISTINCT to avoid turning duplicate highest number

SELECT 
    IFNULL(
        (SELECT DISTINCT Salary
         FROM Employee
         ORDER BY Salary DESC
         LIMIT 1 OFFSET 1        
        ), NULL
    ) AS SecondHighestSalary