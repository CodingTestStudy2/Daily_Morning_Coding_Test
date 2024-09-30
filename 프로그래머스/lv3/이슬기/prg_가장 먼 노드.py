'''
가장 멀리 떨어진 노드만 구하면 됨 -> BFS
'''

from collections import deque

def solution(n, edge):
    answer = 0
    
    graph = list([] for _ in range(n+1))
    visited = [False for _ in range(n+1)]
    
    for i in range(len(edge)):
        a, b = edge[i]
        graph[a].append(b)
        graph[b].append(a)
    
    q = deque([])
    q.append([1, 0]) # 출발, 거리
    visited[1] = True
    maxValue = 0
    
    while q:
        now_A, dist = q.popleft()
        for nx in graph[now_A]:
            # 아직 방문 안했을 때만
            if not visited[nx]:
                # print(now_A, dist)
                if maxValue < dist+1:
                    answer = 1
                    maxValue = dist+1
                elif maxValue == dist+1:
                    answer += 1
                q.append([nx, dist+1])
                visited[nx] = True
    
    return answer