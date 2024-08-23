# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''


from itertools import combinations
def solution(relation):
    table = relation
    n = len(table)
    m = len(table[0])

    def is_unique(comb):
        seen = set()
        for record in table:
            key = tuple(record[col] for col in comb)
            if key in seen:
                return False
            seen.add(key)
        return True

    def is_minimal(comb): # [1, 2, 3]
        comb = set(comb)
        for candid in candids: # [1, 2]
            match = 0
            for col in candid:
                if col in comb:
                    match += 1
            if match == len(candid):
                return False
        return True


    candids = []
    cols = [i for i in range(m)]
    for size in range(1, m + 1):
        for comb in combinations(cols, size):
            if is_unique(comb) and is_minimal(comb):
                candids.append(comb)

    return len(candids)
