# https://school.programmers.co.kr/learn/courses/30/lessons/12985?language=python3
def solution(n,a,b):
    answer = 0
    while a != b: # 같은 라운드가 아니면
        a = (a+1) // 2
        b = (b+1) // 2
        answer += 1
        
        # (번호+1)//2 => 라운드 
        # r1 = 2 4
        # r2 = 1 2
        # r3 = 1 1

    return answer