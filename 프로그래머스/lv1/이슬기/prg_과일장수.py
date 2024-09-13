'''
정렬 사용
'''

def solution(k, m, score):
    answer = 0
    
    score.sort(key=lambda x:-x)
    n = len(score)
    
    for i in range(n//m):
        answer += score[i*m+m-1] * m
    
    return answer