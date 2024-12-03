'''
약수의 개수 구하기
'''

def solution(e, starts):
    answer = []
    count_list = [1] * (e+1)
    
    for i in range(1, int(e*0.5)+1):
        for j in range(i*2, e+1, i):
            count_list[j] += 1
    
    dp = [0] * (e+1)
    dp[e] = e
    
    for i in reversed(range(1, e)): # 최댓값 구하기
        if count_list[i] >= count_list[dp[i+1]]:
            dp[i] = i
        else:
            dp[i] = dp[i+1]
    
    for start in starts:
        answer.append(dp[start])
    
    return answer