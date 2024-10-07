'''
a = 2 / b = 1일 경우
20병 -> 10병 -> 5병(1병 남음) -> 2병 -> 1병(1병 남음) -> 1병

3 * 6 = 18 (2병 남음)
3 * 2 = 6
'''

def solution(a, b, n):
    answer = 0
    remain = 0
    
    while n > 0:
        cnt = n // a
        remain += n % a
        cnt *= b
        answer += cnt
        n = cnt
        if remain >= a:
            n += remain
            remain = 0 # 초기화
    
    return answer