def solution(n, paths, gates, summits):
    answer = []
    # 조건 1. 처음시작과 끝이 같아야 함
    # 조건 2. 산봉우리는 한번만 (visited)
    # 조건 3. 출입구는 하나만
    # 최소가 중복인 경우, 번호 낮은 순
    
    # 전략 : 다익스트라 활용 gates 별로 해보고 최소 구하기
    gate = [] # gate 후보

    graph = [[] for _ in range(n+1)] # 노드
    
    visited = [False] * (n+1)
    distance = [int(1e9)] * (n+1)
    
    for _ in range(len(paths)): #정보 입력
        u,v,w = map(int, input().split())
        graph[u].append((v,w))
    
    
    # answer : [최소 산봉우리 번호와 intensity 최솟값]
    
    
    return answer