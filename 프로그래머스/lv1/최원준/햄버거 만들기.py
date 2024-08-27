# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''


def solution(ingredient):
    stack = []

    ans = 0
    for n in ingredient:
        if n == 1 and len(stack)>=3 and stack[-3:] == [1,2,3]:
            ans += 1
            for i in range(3):
                stack.pop()
        else:
            stack.append(n)

    return ans