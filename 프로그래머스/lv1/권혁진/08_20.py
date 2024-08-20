def solution(board, h, w):
    answer = 0
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    row = len(board)
    col = len(board[0])
    for dr, dc in directions:
        if 0 <= h+dr < row and 0 <= w+dc < col:
            if board[h+dr][w+dc] == board[h][w]:
                answer += 1
    return answer