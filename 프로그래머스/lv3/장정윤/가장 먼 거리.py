# https://school.programmers.co.kr/learn/courses/30/lessons/49189
from collections import deque

def solution(n, edge):
    graph = [[] for _ in range(n+1)]
    visited = [False] * (n+1)

    for a, b in edge:
        graph[a].append(b)
        graph[b].append(a)

    # bfs를 위한 큐 설정
    q = deque([(1, 0)])  # (노드, 거리)
    visited[1] = True  # 방문 처리
    max_distance = 0 
    count = 0 

    while q:
        node, dist = q.popleft()

        for neighbor in graph[node]:
            if not visited[neighbor]:
                visited[neighbor] = True
                new_dist = dist + 1

                if new_dist > max_distance:
                    max_distance = new_dist
                    count = 1
                elif new_dist == max_distance:
                    count += 1
                q.append((neighbor, new_dist))

    return count
