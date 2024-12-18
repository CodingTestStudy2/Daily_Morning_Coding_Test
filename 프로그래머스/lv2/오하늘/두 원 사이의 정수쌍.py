import math
# 모든 땅 시초
# 수학 : y = r^2 - x^2의 루트 식 이용
def solution(r1, r2):
    answer = 0
    for i in range(1, r2+1): # 1사분면만 구하면 됨.
        
        # 작은 원
        if i < r1:
            s = math.ceil(math.sqrt(r1**2 - i**2))
        else:
            s = 0 # 좌표 없음
        
        # 큰 원
        b = int(math.sqrt(r2**2 - i**2))
        answer+=b-s+1
        
    # 1 더하는 이유 b 포함
    return answer*4 # 4분면