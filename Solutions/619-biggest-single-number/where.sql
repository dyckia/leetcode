SELECT MAX(num) as num
FROM
(
    SELECT num, COUNT(num) as cou
    FROM my_numbers
    GROUP BY num
) AS temp
WHERE temp.cou = 1;