# https://school.programmers.co.kr/learn/courses/30/lessons/12980

def solution(n):
    ans = 0 # 사용 건전지 사용량
    
    while n > 0:
        # 순간이동
        if n % 2 == 0:
            n /= 2
        # 점프
        else:
            n -= 1
            ans += 1
    return ans