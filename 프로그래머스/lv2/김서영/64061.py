""" [1,5,3,5,1, 2,1,4] -1열에 있는 가장 
[[0,0,0,0,0],
 [0,0,1,0,3],
 [0,2,5,0,1],
 [4,2,4,4,2],
 [3,5,1,3,1]]
 4  2 4
"""
def solution(board, moves):
    answer = 0
    n = len(board)
    top = [0 for _ in range(n)] # 각 열의 top 포인터
    global basket
    
    for i in range(n):
        for j in range(n):
            if board[j][i] != 0: 
                top[i] = j
                break
                
    def pop_check() -> int:
        global basket
        if len(basket) < 2: return 0
        a, b = basket.pop(), basket.pop()
        if a == b: return 2
        basket += [b, a]
        return 0
          
    basket = []
    for move in moves:
        i, j = top[move-1], move-1
        if i >= n: continue
        basket.append(board[i][j])
        answer += pop_check()
        top[move-1] += 1
    return answer


solution([[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]],[1,5,3,5,1,2,1,4])