# https://school.programmers.co.kr/learn/courses/30/lessons/12915
def solution(strings, n):
    answer = []
    # 동점인 경우 사전식 정렬 ex) "abce", "abcd"
    answer = sorted(strings, key = lambda x: (x[n], x)) # lambda x: x[n]
    return answer