'''
합이 17
{1, 16} {2, 15} {3, 14} {4, 13} {5, 12} ... {8, 9}
72 -> 중간 값이 가장 최고의 집합인가?

합이 300
{150, 150} {151, 149}
22,500 -> 중간값..
{100, 100, 100} {99, 99, 102}
'''

def solution(n, s):
    answer = []
    
    value = s // n
    remain = s % n
    
    if value == 0:
        return [-1]
    
    answer = list(value for _ in range(n))
    for i in range(remain):
        answer[i] += 1
    
    answer.sort()
    
    return answer