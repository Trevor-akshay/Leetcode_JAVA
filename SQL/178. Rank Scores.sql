SELECT s1.Score as score, 
(SELECT COUNT(DISTINCT s2.Score)+1 FROM Scores s2 WHERE s1.Score< s2.Score) AS 'Rank' 
FROM Scores s1
ORDER BY 1 DESC