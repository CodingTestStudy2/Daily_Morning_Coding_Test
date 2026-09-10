
'''
1. 아이디어 :
90도 회전 후 bfs로 교환

2. 시간복잡도 :
o(n * m)

3. 자료구조/알고리즘 :
'''

from collections import deque
class Solution:
    def rotateTheBox(self, boxGrid: List[List[str]]) -> List[List[str]]:
        x = len(boxGrid[0])
        y = len(boxGrid)
        tmp = [[] for _ in range(x)]
        
        for i in range(y-1, -1, -1):
            for j in range(x):
                tmp[j].append(boxGrid[i][j])
        
        xlen = len(tmp[0])
        ylen = len(tmp)
        
        queue = deque()
        for y in range(ylen):
            for x in range(xlen):
                if tmp[y][x] == '.':
                    queue.append((x,y))
            
        while queue:
            x,y = queue.popleft()
            if y != 0 and tmp[y-1][x] == '#':
                tmp[y-1][x] = '.'
                tmp[y][x] = '#'
                queue.append((x,y-1))
        
        return tmp