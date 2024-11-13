'''
....
..S.
E...
탈출까지 이동해야하는 거리 k
-> 동일한 경로 이동 가능
'''
from collections import deque

def solution(n, m, x, y, r, c, k):
    dx = [1, 0, 0, -1]
    dy = [0, -1, 1, 0]
    dl = ["d", "l", "r", "u"] # 문자열로 이동 나타냄, 우선순위
    
    q = deque([(x, y, 0, "")])
    visited = set((x, y, 0))
    
    while q:
        now_x, now_y, cost, st = q.popleft()
        if cost == k:
            if now_x == r and now_y == c:
                return st
            continue
        
        for i in range(4):
            nx = dx[i] + now_x
            ny = dy[i] + now_y
            if 1 <= nx < n+1 and 1 <= ny < m+1 and (nx, ny, cost+1) not in visited:
                visited.add((nx, ny, cost+1))
                q.append((nx, ny, cost+1, st + dl[i]))
    
    return "impossible"