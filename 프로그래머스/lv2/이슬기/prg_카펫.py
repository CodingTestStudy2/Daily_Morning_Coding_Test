'''
테두리 -> 갈색
전체 카펫 개수 - 갈색 개수 = 노란색 개수
가로 x / 세로 y

(x-2) * 2 + (y-2) * 2 + 4 = 24 (갈색 개수)
(x * y) - 24 = 24 (노란색 개수)
x * y = 48
2x + 2y = 28
t^2 - (x+y)t + x*y = 0
'''
import math

def solution(brown, yellow):
    multi = brown + yellow
    plus = (brown + 4) // 2
    x = int((plus + math.sqrt(plus**2 - 4 * multi)) / 2) # 근의 공식
    y = plus - x
    
    return [x, y]