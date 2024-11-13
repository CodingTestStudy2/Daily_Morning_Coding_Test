'''
[2, 3, 3, 5] 뒤에 있는 숫자들 중, 가장 큰 수
n^2 가 되지 않는 시간 복잡도
'''
from collections import deque

def solution(numbers):
    n = len(numbers)
    answer = [0] * n
    q = deque([])
    answer[n-1] = -1
    q.appendleft(numbers[n-1])
    
    for i in range(n-2, -1, -1):
        while q:
            now = q.popleft()
            if now > numbers[i]: # 더 큰 수
                answer[i] = now
                q.appendleft(now) # 가장 큰 수는 넣음
                break
        answer[i] = -1 if answer[i] == 0 else answer[i]
        q.appendleft(numbers[i])
    
    return answer