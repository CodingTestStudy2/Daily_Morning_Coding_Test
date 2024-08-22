# https://school.programmers.co.kr/learn/courses/30/lessons/42862

def solution(n, lost, reserve):
    new_lost = set(lost) - set(reserve)
    new_reserve = set(reserve) - set(lost)
    for i in new_reserve:
        if i - 1 in new_lost:
            new_lost.remove(i - 1)
        elif i + 1 in new_reserve:
            new_reserve.remove(i + 1)
    return n - len(new_lost)

solution(5, [2, 4], [1, 3, 5])