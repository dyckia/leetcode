-- abs

SELECT DISTINCT a.seat_id
FROM cinema a, cinema b
WHERE ABS(a.seat_id - b.seat_id) = 1 AND a.free = true AND b.free = true
ORDER BY a.seat_id