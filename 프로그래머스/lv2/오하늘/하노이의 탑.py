def dfs(n, start, end, sub, answer):
    if n == 1:
        answer.append([start, end]) # 1개
    else:
        dfs(n-1, start, sub, end, answer) # 2번 기둥으로
        answer.append([start, end]) # 가장 큰 원반을 끝으로
        dfs(n-1, sub, end, start, answer) # 2->3번으로


def solution(n):
    answer = []
    dfs(n, 1, 3, 2, answer)
    
    return answer