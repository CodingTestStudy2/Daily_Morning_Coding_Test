def solution(board, moves):
    basket = []
    answer = 0
    for i in moves:
        for j in board:
            if j[i-1]:
                if basket and j[i-1] == basket[-1]:
                    basket.pop(-1)
                    answer += 2
                    j[i-1] = 0
                    break
                basket.append(j[i-1])
                j[i-1] = 0
                break
    return answer