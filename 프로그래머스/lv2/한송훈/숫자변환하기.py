# ## DP method
# def solution(x, y, n):
#     dp = [9999] * (y + 1 ) * 3
#     dp[x] = 0
    
#     for i in range(x,y+1):
#         if dp[i] == -1: continue
        
#         if i+n <= y:
#             dp[i+n] = min(dp[i+n], dp[i] + 1)
#         if i*2 <= y:
#             dp[i*2] = min(dp[i*2], dp[i] + 1)
#         if i*3 <= y:
#             dp[i*3] = min(dp[i*3], dp[i] + 1)
        
#     return -1 if dp[y] == 9999 else dp[y]

## DFS / BDS Method
from collections import deque

def solution(x,y,n):
    queue = deque()
    queue.append((x,0))
    visited = set()
    visited.add(x)
    while queue:
        now, cnt = queue.popleft()
        
        if now ==y: return cnt
        
        for next_num in [now+n, now*2, now*3]:
            if next_num <=y and next_num not in visited:
                visited.add(next_num)
                queue.append((next_num, cnt+1))
    
    return -1