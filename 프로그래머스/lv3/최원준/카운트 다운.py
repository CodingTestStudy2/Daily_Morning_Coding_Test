# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''


def solution(target):
    candid = set()
    for i in range(1, 21):
        for j in range(1, 4):
            if j == 1: #single
                candid.add((i, 1))
                candid.discard((i,0))
            else:
                if (i*j, 1) not in candid:
                    candid.add((i*j, 0))
    candid = list(candid)
    candid.append((50,1))
    candid.sort()

    dp = [[float('inf'),-float('inf')] for _ in range(target+1)]
    dp[0] = [0,0]

    for num, is_sb in candid:
        for idx in range(num, target+1):
            throws = dp[idx-num][0] + 1
            sb = dp[idx-num][1] + is_sb

            if throws < dp[idx][0]:
                dp[idx] = [throws, sb]
            elif throws == dp[idx][0] and sb > dp[idx][1]:
                dp[idx] = [throws,sb]

    return dp[target]