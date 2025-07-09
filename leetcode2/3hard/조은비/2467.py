class Solution:
    def mostProfitablePath(self, edges: List[List[int]], bob: int, amount: List[int]) -> int:
        # 승자가 있는 경우 - 승 / 동시도달 - 반띵
        # alice 의 최종 수익
        n = len(amount)

        # graph map
        map = [[] for _ in range(n)]
        for a, b in edges:
            map[a].append(b)
            map[b].append(a)

        # bob - DFS 로 최소 경로
        
        
        # 각 위치에서 alice 의 수익 계산
