'''
최소 변환 과정 찾기
 -> 이전 알파벳과 비교해서 한 단어만 달라졌다면, deque에 넣기
 -> 아니라면 넣지 않기
'''
from collections import deque

def solution(begin, target, words):
    q = deque([(begin, 0)])
    visited = list(0 for i in range(len(words)))
    
    while True:
        if not q:
            return 0
        
        now, cnt = q.popleft()
        
        if now == target:
            return cnt
        
        for w in range(len(words)):
            if not visited[w]:
                gap = 0
                for i in range(len(now)):
                    if now[i] != words[w][i]:
                        gap += 1
                if gap == 1:
                    q.append((words[w], cnt+1))
                    visited[w] = 1
    
    return cnt