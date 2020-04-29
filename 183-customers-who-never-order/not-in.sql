SELECT Name Customers
FROM Customers
WHERE Id not in 
(SELECT CustomerId FROM Orders);