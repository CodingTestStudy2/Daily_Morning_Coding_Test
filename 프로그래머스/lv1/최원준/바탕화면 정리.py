# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''


def solution(wallpaper):
    n, m = len(wallpaper), len(wallpaper[0])
    x,y,x2,y2=float('inf'),float('inf'), 0, 0
    for row in range(n):
        for col in range(m):
            if wallpaper[row][col] == "#":
                x, y,x2,y2 = min(x,row), min(y, col), max(x2, row), max(y2,col)

    return [x,y,x2+1,y2+1]