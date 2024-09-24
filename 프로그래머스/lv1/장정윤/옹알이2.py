# https://school.programmers.co.kr/learn/courses/30/lessons/133499
def solution(babbling):
    answer = 0
    can = ["aya", "ye", "woo", "ma"]
    cant = ["ayaaya", "yeye", "woowoo", "mama"] # 연속 같은 발음 불가

    for i in range(len(babbling)):
        word = babbling[i]
        for k in cant:
            if k in word:
                word = word.replace(k, 'x')
        for j in can:
            if j in word:
                word = word.replace(j, ' ')
        word = word.replace(' ', '')
        if not word:
            answer += 1
    return answer