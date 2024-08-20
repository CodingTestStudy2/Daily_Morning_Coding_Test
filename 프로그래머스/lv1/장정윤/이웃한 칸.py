from collections import deque

def solution(board, h, w):
    answer = 0
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]

    q = deque()
    q.append((h,w))

    while q:
        x,y = q.popleft()

        color = board[x][y]

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0<=nx<len(board[0]) and 0<=ny<len(board):
                if board[nx][ny] == board[x][y]:
                    answer += 1
    return answer

