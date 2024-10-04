# 풀이 실패 -> 최소 거리: 크루스칼 알고리즘
def solution(n, costs):
    answer = 0
    uni = [0] * (n + 1)
    costs.sort(key = lambda x: x[2])
    for i in range(1,n + 1):
        uni[i] = i
    # union, find 분리된 집합 관리
    
    # 한 트리의 루트가 다른 트리 루트의 부모로 설정되어
    # 두 집합이 효과적으로 하나로 병합
    def union(x,y):
        a = find(x)
        b = find(y)
        if a != b:
            uni[a] = b
    # x와 루트로 가는 경로에 있는 모든 요소가 루트를 직접 가리키게 되어 트리 구조가 평면화
    # 원소가 속한 집합의 루트 결정
    def find(x):
        if uni[x] == x: return x
        else:
            uni[x] = find(uni[x])
            return uni[x]
    for n1,n2,cost in costs:
        if find(n1) != find(n2):
            union(n1,n2)
            answer += cost
    return answer