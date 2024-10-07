# https://school.programmers.co.kr/learn/courses/30/lessons/161988

def solution(sequence):
    answer = 0
    max_sum1 = 0
    max_sum2 = 0
    
    curr_sum1 = 0
    curr_sum2 = 0
    
    for i in range(len(sequence)):
        if i % 2 == 0:
            curr_sum1 += sequence[i] * 1
            curr_sum2 += sequence[i] * -1
        else:
            curr_sum1 += sequence[i] * -1
            curr_sum2 += sequence[i] * 1
            
        max_sum1 = max(max_sum1, curr_sum1)
        max_sum2 = max(max_sum2, curr_sum2)
        
        if curr_sum1 < 0:
            curr_sum1 = 0
        if curr_sum2 < 0:
            curr_sum2 = 0 

    return max(max_sum1, max_sum2)