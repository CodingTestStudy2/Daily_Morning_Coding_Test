# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''

def solution(n, m, x, y, queries):
    min_x, max_x = x, x
    min_y, max_y = y, y

    queries = queries[::-1]
    for command, dx in queries:
        if command == 0:  # 왼쪽 이동
            max_y = min(m - 1, max_y + dx)
            if min_y != 0:
                min_y = min_y + dx
            min_y = max(0, min_y)
        elif command == 1:  # 오른쪽 이동
            min_y = max(0, min_y - dx)
            if max_y != m - 1:
                max_y = max_y - dx
            max_y = min(m - 1, max_y)
        elif command == 2:  # 위로 이동
            max_x = min(n - 1, max_x + dx)
            if min_x != 0:
                min_x = min_x + dx
            min_x = max(0, min_x)
        elif command == 3:  # 아래로 이동
            min_x = max(0, min_x - dx)
            if max_x != n - 1:
                max_x = max_x - dx
            max_x = min(n - 1, max_x)

        # 범위가 유효하지 않은 경우
        if min_x > max_x or min_y > max_y:
            return 0

    return (max_x - min_x + 1) * (max_y - min_y + 1)







# 시간초과

from collections import defaultdict

def solution(n, m, x, y, queries):
    def get_cords(n, m, x, y, command, dx):
        positions = set()

        if command == 0:
            if y == 0:
                for i in range(dx + 1):
                    new_y = min(m - 1, y + i)
                    positions.add((x, new_y))
            else:
                new_y = y + dx
                if new_y >= m:
                    return set()
                positions.add((x, new_y))

        elif command == 1:
            if y == m - 1:
                for i in range(dx + 1):
                    new_y = max(0, y - i)
                    positions.add((x, new_y))
            else:
                new_y = y - dx
                if new_y < 0:
                    return set()
                positions.add((x, new_y))

        elif command == 2:
            if x == 0:
                for i in range(dx + 1):
                    new_x = min(n - 1, x + i)
                    positions.add((new_x, y))
            else:
                new_x = x + dx
                if new_x >= n:
                    return set()
                positions.add((new_x, y))

        elif command == 3:
            if x == n - 1:
                for i in range(dx + 1):
                    new_x = max(0, x - i)
                    positions.add((new_x, y))
            else:
                new_x = x - dx
                if new_x < 0:
                    return set()
                positions.add((new_x, y))

        return positions

    queries = queries[::-1]
    prev = defaultdict(int)
    prev[(x, y)] = 1
    for q in queries:
        command, dx = q
        curr = defaultdict(int)

        for k, count in prev.items():
            cx, cy = k
            next_cords = get_cords(n, m, cx, cy, command, dx)
            for (nx, ny) in next_cords:
                curr[(nx, ny)] += count
        prev = curr

    return sum(prev.values())