from collections import deque

dx = [1,1,0,0] # 하, 대각선, 우, 본인
dy = [0,1,1,0]

def bfs(x, y, board):
    target = board[x][y] # 타겟 캐릭터
    chk = set([x,y])

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
            
        if 0 <= nx < len(board) and 0 <= ny < len(board[0]):
            if board[nx][ny] == target: # 타겟과 같으면
                chk.add((nx, ny))
                
    if len(chk) == 4:
        return chk
    return set()
                    
def solution(m, n, board): # 높이, 폭, 배치 정보
    answer = 0
    board = [list(row) for row in board]
    
    while True:
        remove = set() # 지울 블록 좌표
        
        for i in range(m):
            for j in range(n):
                if board[i][j] != " ":
                    result = bfs(i,j,board)
                    remove.update(result) # 갱신
        
        if not remove:
            break
    
    
    return answer