# https://school.programmers.co.kr/learn/courses/30/lessons/12971
# 수정..!
def solution(sticker):
    answer = 0
    n = len(sticker)
    if len(sticker) == 1:
        return sticker[0]
    
    # 첫번째 선택한 경우
    dp1 = [0] * n
    dp1[0] = sticker[0]
    dp1[1] = max(sticker[0], sticker[1])
    for i in range(2, n-1):
        dp1[i] = max(dp1[i-1], dp1[i-2]+sticker[i])
    
    # 첫번째 선택 안한 경우
    dp2 = [0] * n
    dp2[0] = 0
    dp2[1] = sticker[1]
    for i in range(2, n):
        dp2[i] = max(dp2[i-1], dp2[i-2]+sticker[i])        

    return max(dp1[n-2], dp2[n-1])