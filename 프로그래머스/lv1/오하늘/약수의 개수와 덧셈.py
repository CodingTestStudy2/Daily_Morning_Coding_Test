import math

def chk(n):
    cnt = 0
    for i in range(1,int(math.sqrt(n))+1): # 제곱근
        if n%i==0:
            cnt+=1
            if i*i!=n:
                cnt+=1
    return cnt

def solution(left, right):
    answer = 0
    
    for i in range(left, right+1):
        n = chk(i)
        if n%2==0:
            answer += i
        else:
            answer -= i
    
    return answer

print(solution(13,17))