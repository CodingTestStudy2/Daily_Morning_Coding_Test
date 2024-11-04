'''
약수의 개수 구하기
'''
import math

def solution(left, right):
    answer = 0
    
    def getDivisor(x):
        cnt = 0
        for i in range(1, int(math.sqrt(x))+1):
            if x % i == 0:
                cnt += 1
                if i * i != x:
                    cnt += 1
        return cnt
    
    for i in range(left, right+1):
        cnt = getDivisor(i)
        answer += i if cnt % 2 == 0 else -i
    
    return answer