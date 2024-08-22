# https://school.programmers.co.kr/learn/courses/30/lessons/131129

def solution(target):
    if target < 20:
        return [1, 1]

    scores = set()
    for i in range(1, 21):
        scores.add(i)        
        scores.add(i * 2)   
        scores.add(i * 3)    
    scores.add(50)

    dp = [float('inf')] * (target + 1)
    dp[0] = 0
    dp_1 = [0] * (target + 1)

    for i in range(1, target + 1):
        for score in scores:
            if i >= score:
                if dp[i] > dp[i - score] + 1:
                    dp[i] = dp[i - score] + 1
                    dp_1[i] = dp_1[i - score]
                    if score in range(1, 21) or score == 50:
                        dp_1[i] += 1
                elif dp[i] == dp[i - score] + 1:
                    if score in range(1, 21) or score == 50:
                        dp_1[i] = max(dp_1[i], dp_1[i - score] + 1)
    return [dp[target], dp_1[target]]

print(solution(58))