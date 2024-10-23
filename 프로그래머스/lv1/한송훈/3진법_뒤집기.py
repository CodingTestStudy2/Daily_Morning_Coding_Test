def solution(n):
    answer_list = []
    while n > 0:
        n, mod = divmod(n, 3)
        answer_list.append(mod)
    
    answer = 0
    mul = 1
    for i in answer_list[::-1]:
        answer += (i*mul)
        mul *= 3
    
    return answer