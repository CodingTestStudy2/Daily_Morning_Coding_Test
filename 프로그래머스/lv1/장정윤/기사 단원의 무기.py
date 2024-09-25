import math
def solution(number, limit, power):
    answer = 0
    
    # 1 2 2 3 2 => 합산 10
    # 1 2 2 3 2 4 2 4 3 4 => 3보다 큰 수는 power 수로 대치 10 11 = 21
    cnt_list = []
    for i in range(1, number+1):
        cnt_num = 0
        # for j in range(1, i+1):
        #     if i % j == 0:
        #         cnt_num += 1
        # i 의 제곱근
        for j in range(1, int(math.sqrt(i)) + 1):
            if i % j == 0:
                cnt_num += 1
                if j != i // j:  # 서로 다른 약수인 경우
                    cnt_num += 1
        cnt_list.append(cnt_num)
        
    for k in range(len(cnt_list)):
        if cnt_list[k] > limit:
            cnt_list[k] = power
    
    return sum(cnt_list)