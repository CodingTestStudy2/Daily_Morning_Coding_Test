# bfs로 풀다가 안풀려서, 풀이 참조.

class Solution:
    def countSubTrees(self, n: int, edges: List[List[int]], labels: str) -> List[int]:
        graph = defaultdict(list) # 키가 존재하지 않아도 되는 딕셔너리
        for a, b in edges:
            graph[a].append(b)
            graph[b].append(a)

        ans = [0] * n

        def dfs(node, p): 
            count = defaultdict(int) # 레이블 별 개수 카운트

            label = labels[node]
            count[label] += 1 # 레이블 개수 증가

            for n in graph[node]:
                if n == p: # 이웃이 부모와 같으면
                    continue
                child = dfs(n, node) # 자식 노드
                for key, val in child.items():
                    count[key] += val # 자식 노드 레이블 정보 노드에 합산
            
            ans[node] = count[label]
            return count

        dfs(0,-1)
        return ans
