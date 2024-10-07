'''
10일 동안 회원 자격
sliding window => 10 차이만큼
'''
from collections import defaultdict, Counter

def solution(want, number, discount):
    answer = 0
    n = len(want)
    m = len(discount)
    want_product = defaultdict(int)
    
    for i in range(n):
        want_product[want[i]] = number[i]
    
    def is_sales(counter):
        for p in want_product:
            if want_product[p] > counter[p]:
                return False
        return True
    
    right = 9 if m >= 10 else m-1
    counter = Counter(discount[:right+1])
    
    if is_sales(counter):
        answer += 1
    
    if m > 10: # discount 날짜가 10일 초과일 때만
        for i in range(m-10): # (0, 1, 2, 3)
            j = i + 10
            counter.update([discount[j]])
            counter.subtract([discount[i]])
            # print(counter)
            if is_sales(counter):
                answer += 1
    
    return answer