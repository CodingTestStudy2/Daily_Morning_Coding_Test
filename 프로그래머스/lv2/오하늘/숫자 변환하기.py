from collections import deque

def solution(x, y, n):
    answer = 0
    q = deque([(x, 0)]) # x, 횟수
    visited = set([x]) # set 처리 안해주면 시간초과 O(1)
    
    while q:
        x, step = q.popleft()
        if x == y:
            return step
        
        for next in (x+n, x*2, x*3):
            if next<=y:
                if not next in visited:
                    q.append((next,step+1))
                    visited.add(next)
    
    return -1