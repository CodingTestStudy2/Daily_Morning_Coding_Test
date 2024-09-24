# https://school.programmers.co.kr/learn/courses/30/lessons/12911
def solution(n):
    answer = 0
    # 2진수로 변환, 문자열로 바꿔서 1 카운트
    binary = bin(n)
    cnt = n + 1
    while cnt < 1000001:
        if str(binary).count('1') == str(bin(cnt)).count('1'):
            return cnt
        else:    
            cnt += 1