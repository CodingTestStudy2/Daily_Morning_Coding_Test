def solution(board, moves):
    # print(*board, sep='\n')
    n = len(board)
    m = len(board[0])
    cords = []
    for col in range(m):
        found=False
        for row in range(n):
            if board[row][col] != 0:
                cords.append(row)
                break
        else:
            cords.append(-1)

    ans = 0
    stack = []
    for idx in moves:
        idx-=1
        if cords[idx] == -1: continue
        row = cords[idx]
        val = board[row][idx]
        if stack and stack[-1] == val:
            stack.pop()
            ans+=2
        else:
            stack.append(val)
        if row+1 == n:
            cords[idx] = -1
        else:
            cords[idx] = row+1
    return ans