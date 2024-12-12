# def dfs(cnt, n, k, enemy):
#     if cnt == len(enemy) or (n == 0 and k == 0):
#         return cnt

#     # 무적권 사용
#     case1 = dfs(cnt+1, n, k-1, enemy)
#     # 무적권 미사용
#     case2 = dfs(cnt+1, max(0, n-enemy[cnt]), k, enemy)

#     return max(case1, case2)

# def solution(n, k, enemy):
#     answer = dfs(0, n, k, enemy)
#     return answer
import heapq

def solution(n, k, enemy):
    round = len(enemy)
    if k>= round: # 무적권이 충분한 경우
        return round
    q = []
    
    for i in range(round):
        heapq.heappush(q, enemy[i])
        if len(q) > k: # 무적권이 없음
            last = heapq.heappop(q)
            if last>n: # 병사가 부족하면
                return i
            n-=last
            
    return round

print(solution(7,3,[4, 2, 4, 5, 3, 3, 1]))