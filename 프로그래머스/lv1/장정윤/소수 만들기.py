# https://school.programmers.co.kr/learn/courses/30/lessons/12977
from itertools import *
def solution(nums):
    answer = 0
    # 세가지 값을 더한다, 소수인지 확인한다.
    # 소수 조건 : 나눴을 때 나머지가 0인 값이 1과 자기자신 뿐

    total_nums = [] 
    def is_prime_num(n):
        for i in range(2, n):
            if n % i == 0:
                return False
        return True

    total_nums = list(combinations(nums,3)) # [(1,2,3),(2,3,4)]
    
    for i in range(len(total_nums)):
        if is_prime_num(sum(total_nums[i])):
            answer += 1

    return answer