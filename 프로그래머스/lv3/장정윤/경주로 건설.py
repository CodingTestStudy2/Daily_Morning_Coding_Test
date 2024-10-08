# https://school.programmers.co.kr/learn/courses/30/lessons/67259

from collections import deque

def solution(board):
    N = len(board)
    cost = [[[float('inf')] * 4 for _ in range(N)] for _ in range(N)]
    
    directions = [(-1,0), (1,0), (0,-1), (0,1)]
    
    q = deque([(0,0,-1,0)])
    
    for i in range(4):
        cost[0][0][i] = 0
        
    while q:
        x, y, prev_dir, curr_cost = q.popleft()
        
        # 4개 방향 이동 시도
        for i, (dx, dy) in enumerate(directions):
            nx, ny = x+dx, y+dy
            
            # 도로 안쪽이고 벽이 아닌 경우
            if 0 <= nx < N and 0 <= ny < N and board[nx][ny] == 0:
                new_cost = curr_cost + 100
                # 방향이 바뀌는 경우 코너 비용 추가
                if prev_dir != -1 and prev_dir != i:
                    new_cost += 500
                    
                # 더 적은 비용으로 갈 수 있으면 갱신
                if new_cost < cost[nx][ny][i]:
                    cost[nx][ny][i] = new_cost
                    q.append((nx,ny,i,new_cost))
                    
    return min(cost[N-1][N-1])