SELECT a.Name Employee
FROM Employee a 
INNER JOIN Employee b
ON a.ManagerId = b.Id
WHERE a.salary > b.salary
;