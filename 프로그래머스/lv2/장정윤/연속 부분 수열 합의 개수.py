from itertools import product
def solution(elements):
    answer = 0
    n = len(elements)
    # n개 연속 합치고, 결과 값 중복은 제거
    
    # 순환 수열 리스트 2배
    elements = elements * 2
    unique_values = set()
    
    for end in range(1, n + 1):
        for start in range(n):
            #start부터 end idx 원소 더함
            sum_value = sum(elements[start:start+end])
            unique_values.add(sum_value)
        
    return len(unique_values)