# https://school.programmers.co.kr/learn/courses/30/lessons/87390
def solution(n, left, right):
    answer = []    
    for i in range(left, right+1):
        row = i // n
        col = i % n
        answer.append(max(row, col)+1)
    # 시간 초과
    # for i in range(1, n+1):
    #     for j in range(1, n+1):
    #         answer.append(max(i,j))
    
            
    return answer

    # [1,2,3,2,2,3,3,3,3]  
    # 1,1 => 1
    # 1,2 => 2
    # 1,3 => 3
    # 2,1 => 2
    # 2,2 => 2
    # 2,3 => 3
    # 3,1 => 3
    # 3,2 => 3
    # 3,3 => 3
