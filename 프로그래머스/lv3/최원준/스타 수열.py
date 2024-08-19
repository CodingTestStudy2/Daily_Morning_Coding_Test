# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''

from collections import Counter, defaultdict

def solution(a):
    size = len(a)
    if len(a) < 2:
        return 0

    indexes = defaultdict(list)
    for i, n in enumerate(a):
        indexes[n].append(i)
    counts = sorted([(v,k) for k, v in indexes.items()], key=lambda x: -len(x[0]))

    ans = 0
    for indexes, num in counts:
        if len(indexes) < ans:
            continue
        count = 0
        i = 0
        while i < size - 1:
            if (a[i] == num or a[i+1] == num) and a[i] != a[i+1]:
                count += 1
                i += 2
            else:
                i += 1
        ans = max(ans, count)

    return ans * 2







