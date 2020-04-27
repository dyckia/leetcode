SELECT p.FirstName, p.LastName, a.City, a.State
FROM Person p
LEFT OUTER JOIN Address a
ON p.PersonID = a.PersonID