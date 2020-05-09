SELECT ROUND
(
    IFNULL
    (
        (SELECT COUNT(*) FROM (SELECT DISTINCT requester_id, accepter_id FROM request_accepted) AS temp1) /
        (SELECT COUNT(*) FROM (SELECT DISTINCT sender_id, send_to_id FROM friend_request) AS temp2)
        , 0
    )
    , 2
) AS accept_rate;