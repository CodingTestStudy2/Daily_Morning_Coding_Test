'''
피보나치 수
-> DP
'''

def solution(n):
    function = list(0 for _ in range(n+1))
    function[1] = 1
    
    for i in range(2, n+1):
        function[i] = (function[i-1] + function[i-2]) % 1234567
    
    return function[n]