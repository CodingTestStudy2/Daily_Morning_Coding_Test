'''
에라토스테네스의 체!
'''
import math

def solution(n):
    numbers = list(True for _ in range(n+1))
    numbers[0], numbers[1] = False, False
    
    for i in range(2, int(math.sqrt(n)) + 1):
        j = 2
        while i * j <= n:
            numbers[i*j] = False
            j += 1
    
    return numbers.count(True)