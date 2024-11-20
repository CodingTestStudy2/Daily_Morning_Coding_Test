import math
def solution(n):
    answer = 0
    
    a = n**0.5
    k = math.ceil(a)
    if a == k: return (a+1)**2
    else : return -1