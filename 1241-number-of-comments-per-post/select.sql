SELECT 
    DISTINCT a.sub_id AS post_id,
    (
        SELECT COUNT(DISTINCT b.sub_id)
        FROM Submissions b
        WHERE a.sub_id = b.parent_id
    ) AS number_of_comments
FROM Submissions a
WHERE parent_id IS NULL
ORDER BY a.sub_id