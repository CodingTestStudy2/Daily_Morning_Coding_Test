'''
ICN -> JFK -> HND -> IAD
항공권 순서
DFS 사용하기
1. 시작점에서 끝점으로 갈 수 있는 방법 찾기
2. 도착했을 때, 모든 티켓을 사용했다면 ok
2. 도착했을 때, 사용하지 않은 티켓이 있다면 다른 경로 탐색
'''
def solution(tickets):
    n = len(tickets)
    
    tickets.sort(key=lambda x: (x[0], x[1]))
    
    def dfs(visited, x, start, cnt):
        if cnt == n+1:
            return
        
        for t in range(start, n):
            if tickets[t][0] != x or visited[t]: continue
            
            visited[t] = True
            road[cnt] = tickets[t][1]
            # print(visited, road)
            dfs(visited, tickets[t][1], 0, cnt+1)
    
    for start in range(n):
        visited = [False for _ in range(n)]
        road = [""] * (n+1)
        road[0] = "ICN"
        dfs(visited, "ICN", start, 1)
        if "" not in road:
            break
    
    #print("ddd", road)
    
    return road

'''
두번째 풀이
'''

def solution(tickets):
    n = len(tickets)

    tickets.sort(key=lambda x: (x[0], x[1]))
    
    def dfs(visited, x, cnt, road):
        if cnt == n+1:
            return road
        
        for t in range(n):
            if tickets[t][0] == road[cnt-1] and not visited[t]:
                visited[t] = True
                road[cnt] = tickets[t][1]
                
                result = dfs(visited, t, cnt+1, road)
                if result:
                    return result
                
                visited[t] = False
        return None
    
    for start in range(n):
        if tickets[start][0] == "ICN":
            visited = [False] * n
            road = [""] * (n + 1)
            road[0], road[1] = "ICN", tickets[start][1]
            visited[start] = True
            
            result = dfs(visited, start, 2, road)
            if result:
                return result