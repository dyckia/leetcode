SELECT a.Name Employee
FROM Employee a, Employee b
WHERE a.ManagerId = b.Id AND a.salary > b.salary
;