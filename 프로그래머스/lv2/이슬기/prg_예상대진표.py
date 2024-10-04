'''
1 - 2 / 3 - 4 / 5 - 6 / 7 - 8
이런 식..
a 4 -> 2 -> 1
b 7 -> 4 -> 2
'''
import math

def solution(n,a,b):
    answer = 1
    m = int(math.log2(n))
    
    for i in range(m):
        if abs(a - b) == 1 and abs(a // 2 - b // 2) == 1: # 이번 라운드에서 붙으면
            break
        a = a // 2 if a % 2 == 0 else a // 2 + 1
        b = b // 2 if b % 2 == 0 else b // 2 + 1
        answer += 1
    
    return answer