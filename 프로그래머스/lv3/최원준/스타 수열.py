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
    print(counts)

    ans = 0
    for indexes, num in counts:
        indexes_set = set(indexes)
        stack = []
        i = 0
        while i<len(indexes):
            if i in indexes~~~~~~~




