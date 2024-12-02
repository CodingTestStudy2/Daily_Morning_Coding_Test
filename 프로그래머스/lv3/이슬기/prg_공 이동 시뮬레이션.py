'''

'''

def solution(n, m, x, y, queries):
    answer = 0
    visited = [[False] * m for _ in range(n)]
    
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]
    
    start = []
    for i in range(n):
        for j in range(m):
            start.append([i, j])
    
    for st in start:
        a, b = st
        for query in queries:
            arrow, i = query
            if 0 <= a + (dx[arrow] * i) < n:
                nx = a + (dx[arrow] * i)
            else:
                nx = 0 if a + (dx[arrow] * i) < 0 else n-1
            if 0 <= b + (dy[arrow] * i) < m:
                ny = b + (dy[arrow] * i)
            else:
                ny = 0 if b + (dy[arrow] * i) < 0 else m-1
            a = nx
            b = ny
        #print(nx, ny)
        if nx == x and ny == y:
            answer += 1
    
    return answer