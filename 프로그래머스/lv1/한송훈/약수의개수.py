def solution(left, right):
    answer = 0

    # for each_number in range(left, right+1):
    #     num_cnt = 0
    #     for i in range(1, each_number+1):
    #         if each_number % i == 0: num_cnt +=1
    #     if num_cnt % 2 == 0: 
    #         answer += each_number
    #     else:
    #         answer -= each_number
    
    for each_number in range(left, right+1):
        num_set = set()
        for i in range(1, int(each_number**(1/2))+1):
            if each_number % i == 0: 
                num_set.add(i)
                num_set.add(each_number//i)
        if len(num_set) % 2 == 0: 
            answer += each_number
        else:
            answer -= each_number
    
    return answer