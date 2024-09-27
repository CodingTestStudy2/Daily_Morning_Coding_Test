'''
15 => 1, 3, 5, 15
5 => 5
'''

def solution(arr):
    answer = 0
    
    if (len(arr) == 0): return arr[0]
    
    # 유클리드 호제법
    def gcd(a, b):
        r = a % b
        if (r == 0):
            return b
        else:
            return gcd(b, r)
    
    res = 0
    for i in range(1, len(arr)):
        if i == 1:
            res = arr[i-1]
        g = gcd(res, arr[i]) # 최대공약수 구하기
        res = int((res * arr[i]) / g) # 최대공배수 구하기
    
    return res