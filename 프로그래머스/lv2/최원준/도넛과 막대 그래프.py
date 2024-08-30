# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''


from collections import defaultdict, deque
def solution(edges):
    outer = defaultdict(set)
    inner = defaultdict(set)
    nodes = set()
    for u, v in edges:
        nodes.add(u)
        nodes.add(v)
        outer[u].add(v)
        inner[v].add(u)

    def check_stick(node):
        visited = set()
        visited.add(node)
        queue = deque()
        queue.append(node)

        while queue:
            curr = queue.popleft()
            if len(outer[curr])>=2:
                return False
            for nxt in outer[curr]:
                if nxt in visited:
                    return False
                visited.add(nxt)
                queue.append(nxt)
        return True

    def check_donut(node):
        queue=deque()
        queue.append(node)

        while queue:
            curr = queue.popleft()
            if len(outer[curr]) >= 2:
                return False
            for nxt in outer[curr]:
                if node == nxt:
                    return True
                queue.append(nxt)
        return False

    candid = set()
    for node in nodes:
        if node not in inner and len(outer[node])>=2:
            candid.add(node)
    ans =[0,0,0,0]

    for node in candid:
        temp = [node,0,0,0]
        total = len(outer[node])
        outer_nodes = outer[node]
        for outer_node in outer_nodes:
            inner[outer_node].remove(node)

            if check_stick(outer_node):
                temp[2] += 1
                total -=1
            elif check_donut(outer_node):
                temp[1] += 1
                total -=1
            else:
                temp[3] += 1
                total -= 1

            inner[outer_node].add(node)
        if total == 0:
            return temp

    return 0