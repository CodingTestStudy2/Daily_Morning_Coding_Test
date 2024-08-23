def solution(board, moves):
    answer = 0
    # moves 순회한다.
    basket = []
    count = 0

    # board[j]의 마지막 원소를 잡아서 넣어야 함
    # board[j][0] ~ board[j][n-1] 순회
    for idx in moves:
        for row in board:
            if row[idx-1] != 0:
                now = row[idx-1]
                row[idx-1] = 0
                if basket and basket[-1] == now:
                    basket.pop()
                    count+= 2
                    break
                else:
                    basket.append(now)
                break

    return count