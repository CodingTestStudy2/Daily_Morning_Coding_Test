def solution(n, m, x, y, queries):
    
    top, left, bottom, right = x, y, y, x
    queries.reverse()
    for i, j in queries:
        # print(i, j)
        
        # 이동 전 위치: 열 증가 -> left가 0일때만 둘 다 j만큼 증가
        if i == 0: 
            # 증가 상한 m-1 검사
            if right + j < m: tmp = right + j
            else: tmp = m-1
            if left == 0: right = tmp
            else: left, right = left+j, tmp

        # 이동 전 위치: 열 감소 -> right가 m-1일때만 둘 다 j만큼 감소
        if i == 1: 
            if left + j >= 0: tmp = left - j
            else: tmp = 0
            if right == m - 1: left = tmp
            else: left, right = tmp, right-j

        # 이동 전 위치: 행 증가 -> bottom 0일때만 둘 다 j만큼 증가
        if i == 2: 
            if top + j < n: tmp = top + j
            else: tmp = n-1
            if bottom == 0: top = tmp
            else: top, bottom = tmp, bottom + j
        
        # 이동 전 위치: 행 감소 -> top 0일때만 둘 다 j만큼 감소 
        if i == 3: 
            if bottom - j >= 0: tmp = bottom - j
            else: tmp = 0
            if top == 0: bottom = tmp
            else: top, bottom = top-j, tmp

        if left < 0 or right >= m or top >= n or bottom < 0: break
        else: answer = (top-bottom+1) * (right - left+1)

    return answer



