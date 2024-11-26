# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

def solution(sequence, k):
    ans = [0,0]
    max_length = float('inf')

    total = 0
    left = 0
    for right in range(len(sequence)):
        total += sequence[right]

        while total > k:
            total -= sequence[left]
            left+=1

        if total == k and right-left+1 < max_length:
            ans = [left, right]
            max_length = right-left+1

    return ans
'''



