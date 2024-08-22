# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''

from collections import deque

def solution(board, h, w):
    n = len(board)
    m = len(board[0])

    dir = [[0, 1], [0, -1], [1, 0], [-1, 0]]

    count = 0
    color = board[h][w]

    for x2, y2 in dir:
        nx, ny = h + x2, w + y2
        if not (0 <= nx < n and 0 <= ny < m) or board[nx][ny] != color:
            continue
        count += 1
    return count

    '''
    queue = deque()
    queue.append((h, w))
    visited = set()
    visited.add((h,w))
    
    while queue:
        x, y = queue.popleft()
        
        for x2, y2 in dir:
            nx, ny = x+x2, y+y2
            if not (0<=nx<n and 0<=ny<m) or (nx, ny) in visited or board[nx][ny] != color: 
                continue
            visited.add((nx, ny))
            count += 1
            queue.append((nx, ny))
    
    return count
    print(*board, sep='\n')
    answer = 0
    '''

    return answer
