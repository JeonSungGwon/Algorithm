SELECT D.ID, D.EMAIL, D.FIRST_NAME, D.LAST_NAME
FROM DEVELOPERS D
WHERE EXISTS (
    SELECT 1
    FROM SKILLCODES SC
    WHERE (D.SKILL_CODE & SC.CODE) > 0
    AND SC.NAME IN ('Python', 'C#')
)
ORDER BY D.ID;