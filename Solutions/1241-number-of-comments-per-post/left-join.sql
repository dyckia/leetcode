SELECT a.sub_id AS post_id, COUNT(DISTINCT b.sub_id) AS number_of_comments
FROM Submissions a
LEFT OUTER JOIN Submissions b
ON a.sub_id = b.parent_id
WHERE a.parent_id IS null
GROUP BY a.sub_id