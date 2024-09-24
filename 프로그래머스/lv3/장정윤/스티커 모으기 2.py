# https://school.programmers.co.kr/learn/courses/30/lessons/12971
# 틀림..!
def solution(sticker):
    answer = 0    
    # 퐁당퐁당 x
    # 처음 o, 마지막 x, 마지막 o, 처음 x
    
    if len(sticker) == 1:
        return sticker[0]
    
    def calc_sticker_num(arr):
        n = len(arr)
        dp = [0] * n
        dp[0] = arr[0]
        dp[1] = min(arr[0], arr[1])
        
        for i in range(2, len(arr)):
            dp[i] = max(dp[i-2] + arr[i], dp[i-1])
        return dp[-1] # 마지막 원소(총합)
    # 첫번째 o (마지막 x)
    case1 = calc_sticker_num(sticker[:-1])
    # 첫번째 x (마지막 o)
    case2 = calc_sticker_num(sticker[1:])
    
    return max(case1, case2)