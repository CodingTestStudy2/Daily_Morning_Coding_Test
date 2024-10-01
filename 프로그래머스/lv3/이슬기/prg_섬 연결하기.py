'''
최소 비용
=> 동일한 다리를 여러 번 건널 수 있음(방향이 없음)
=> 최소 신장 트리 만들어라.

cost <= 99 * 100 / 2
'''
import heapq

def solution(n, costs):
    answer = 0
    parent = [i for i in range(n)]
    q = []
    for i in range(len(costs)):
        heapq.heappush(q, (costs[i][2], costs[i][0], costs[i][1]))
    
    def find_parent(parent, x):
        if parent[x] != x:
            parent[x] = find_parent(parent, parent[x])
        return parent[x]
    
    def union_parent(parent, x, y):
        x = find_parent(parent, x)
        y = find_parent(parent, y)
        if x < y:
            parent[y] = x
        else:
            parent[x] = y
    
    while q:
        value, x, y = heapq.heappop(q)
        if find_parent(parent, x) != find_parent(parent, y):
            union_parent(parent, x, y)
            answer += value
    
    return answer