SELECT id,
    SUM(case WHEN month = 'Jan' THEN revenue ELSE NULL END) AS Jan_Revenue,
    SUM(case WHEN month = 'Feb' THEN revenue ELSE NULL END) AS Feb_Revenue,
    SUM(case WHEN month = 'Mar' THEN revenue ELSE NULL END) AS Mar_Revenue,
    SUM(case WHEN month = 'Apr' THEN revenue ELSE NULL END) AS Apr_Revenue,
    SUM(case WHEN month = 'May' THEN revenue ELSE NULL END) AS May_Revenue,
    SUM(case WHEN month = 'Jun' THEN revenue ELSE NULL END) AS Jun_Revenue,
    SUM(case WHEN month = 'Jul' THEN revenue ELSE NULL END) AS Jul_Revenue,
    SUM(case WHEN month = 'Aug' THEN revenue ELSE NULL END) AS Aug_Revenue,
    SUM(case WHEN month = 'Sep' THEN revenue ELSE NULL END) AS Sep_Revenue,
    SUM(case WHEN month = 'Oct' THEN revenue ELSE NULL END) AS Oct_Revenue,
    SUM(case WHEN month = 'Nov' THEN revenue ELSE NULL END) AS Nov_Revenue,
    SUM(case WHEN month = 'Dec' THEN revenue ELSE NULL END) AS Dec_Revenue
FROM Department
GROUP BY id;