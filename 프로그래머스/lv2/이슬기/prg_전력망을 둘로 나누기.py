'''
전선들 중 하나를 끊었을 때 전력망 개수 모두 구하기
 -> 가장 차이가 적은 것
'''
from collections import Counter

def solution(n, wires):
    answer = int(1e9)
    
    def find_parent(parent, x):
        if parent[x] != x:
            parent[x] = find_parent(parent, parent[x])
        return parent[x]

    def union_parent(parent, a, b):
        a = find_parent(parent, a)
        b = find_parent(parent, b)
        if a < b:
            parent[b] = a
        else:
            parent[a] = b
    
    for i in range(n-1): # i번째 wire가 없을 경우
        parent = [i for i in range(n+1)]
        
        for j in range(n-1):
            a, b = wires[j]
            if i == j or find_parent(parent, a) == find_parent(parent, b):
                continue
            union_parent(parent, a, b)
        
        value = []
        for i in range(1, n+1):
            value.append(find_parent(parent, i))
        
        value = Counter(value)
        v = list(value.values())
        answer = min(answer, abs(v[0] - v[1]))
    
    return answer
