# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''


from collections import deque
def solution(cap, n, deliveries, pickups):
    d = deque([0])
    p = deque([0])
    for i in range(n):
        d.append(d[-1] + deliveries[-1-i])
        p.append(p[-1] + pickups[-1-i])

    ans = 0
    boxes = 0
    while d or p:
        while d and d[0]-boxes <= 0 and p and p[0]-boxes <= 0:
            d.popleft()
            p.popleft()
        ans += len(d)
        boxes += cap

    return ans*2
