def solution(price, money, count):
    answer = -1
    
    # 등차수열의 합 공식
    answer = (count*(price+price*count)//2) - money
    
    if answer < 0 : return 0
    else : return answer