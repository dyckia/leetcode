UPDATE salary
SET sex =
    CASE sex
        WHEN 'm' THEN 'f'
        ELSE 'm'
    END
    -- OR
    CASE
        WHEN sex = 'm' THEN 'f'
        ELSE 'm'
    END
;