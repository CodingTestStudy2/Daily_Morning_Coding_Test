# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''


def solution(n, lost, reserve):
    reserve = set(reserve)
    lost = set(lost)

    reserve, lost = reserve - lost, lost-reserve

    for l in lost:
        if l-1 in reserve:
            reserve.remove(l-1)
        elif l+1 in reserve:
            reserve.remove(l+1)
        else:
            n-=1
    return n