-- handle where there are mutiple max order users

SELECT customer_number
FROM orders
GROUP BY customer_number
HAVING COUNT(order_number) = 
(
    SELECT MAX(numOfOrder)
    FROM (
        SELECT customer_number, count(order_number) as numOfOrder
        FROM orders
        GROUP BY customer_number
    ) AS temp
)