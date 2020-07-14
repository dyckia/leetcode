-- use MOD(id, 2) = 1 to check if id is odd
-- use description != 'boring' to check if movie is not boring

SELECT *
FROM cinema
WHERE MOD(id, 2) = 1 AND description <> 'boring'
ORDER BY rating DESC;