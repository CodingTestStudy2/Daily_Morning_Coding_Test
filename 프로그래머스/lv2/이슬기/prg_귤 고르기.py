'''
[1, 3, 2, 5, 4, 5, 2, 3] -> Counter
{1 : 1, 2 : 2, 3 : 2, 4 : 1, 5 : 2}
-> 2, 3, 5만~
'''
from collections import Counter

def solution(k, tangerine):
    answer = 0
    
    tan_counter = Counter(tangerine).most_common()
    have_cnt = 0
    
    for item in tan_counter:
        a, cnt = item
        have_cnt += cnt
        answer += 1
        if have_cnt >= k:
            return answer