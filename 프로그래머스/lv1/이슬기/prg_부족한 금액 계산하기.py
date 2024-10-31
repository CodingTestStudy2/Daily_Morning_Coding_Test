'''
price원 => N번째
3 6 9 12
'''

def solution(price, money, count):
    cost = 0
    
    for i in range(1, count+1):
        cost += price * i
    
    if cost - money <= 0:
        return 0
    
    return cost - money