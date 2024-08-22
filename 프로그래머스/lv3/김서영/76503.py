def solution(a, edges):
    if sum(a) != 0: return -1

    graph = [[] for _ in range(len(a))]
    for s1, s2 in edges:
        graph[s1].append(s2)
        graph[s2].append(s1)
    
    def dfs(node):
        visited[node] = True
        total_moves = 0
        
        for neighbor in graph[node]:
            if not visited[neighbor]:
                total_moves += dfs(neighbor)
        total_moves += abs(a[node])
        if node != 0: a[graph[node][0]] += a[node]
        a[node] = 0
        return total_moves
    
    visited = [False] * len(a)
    return dfs(0)