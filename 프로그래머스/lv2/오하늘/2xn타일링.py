def solution(n): 
    # DP
    # f(n) = f(n-2)+f(n-1) 점화식
    d = [0]*600000
    
    d[1] = 1
    d[2] = 2
    
    for i in range(3,n+1):
        d[i] = (d[i-2]+d[i-1])%1000000007
    
    return d[n]%1000000007