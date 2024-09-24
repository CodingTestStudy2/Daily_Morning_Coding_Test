# https://school.programmers.co.kr/learn/courses/30/lessons/42889
def solution(N, stages):
    answer = []
    dic = {}
    calc = {}
    remain_user = len(stages)
    
    for i in range(len(stages)):
        dic[stages[i]] = dic.get(stages[i], 0) + 1
    
    for lv in range(1, N+1):
        if remain_user > 0:
            if dic.get(lv, 0) > 0:
                calc[lv] = dic[lv] / remain_user
                remain_user -= dic[lv]
            else:
                calc[lv] = 0 
        else:
            calc[lv] = 0
    answer = sorted(calc, key = lambda x :(-calc[x],x))
        
    return answer