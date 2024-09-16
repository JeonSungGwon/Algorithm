select count(*) as 'FISH_COUNT'
from FISH_INFO f join FISH_NAME_INFO i
on f.FISH_TYPE = i.FISH_TYPE
where i.FISH_NAME IN ('BASS', 'SNAPPER');