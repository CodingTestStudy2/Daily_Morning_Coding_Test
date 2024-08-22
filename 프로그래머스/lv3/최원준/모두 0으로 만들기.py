# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''


from collections import defaultdict
def solution(a, edges):
    n = len(a)
    graph = defaultdict(set)
    neighbors = [0] * len(a)

    for u, v in edges:
        graph[u].add(v)
        graph[v].add(u)
        neighbors[u] += 1
        neighbors[v] += 1
    # print(graph)
    # print(neighbors)
    # print(a)
    # print()
    leaves = [i for i in range(n) if neighbors[i] == 1]

    counts = 0
    for _ in range(n):
        new_leaves = []
        for leaf in leaves:
            if neighbors[leaf] == 1:
                neighbors[leaf] = 0

                neighbor = list(graph[leaf])[0]
                neighbors[neighbor] -= 1
                if neighbors[neighbor] == 1:
                    new_leaves.append(neighbor)
                graph[neighbor].remove(leaf)

                a[neighbor] += a[leaf]
                counts += abs(a[leaf])
                a[leaf] = 0
        leaves = new_leaves

    return counts if sum(a) == 0 else -1