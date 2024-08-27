from itertools import combinations_with_replacement


def solution(n, info):
    answer = [-1]
    max_diff = 0

    print(list(combinations_with_replacement(range(0, 3), 3)))
    for i in list(combinations_with_replacement(range(0, 3), 3)):
        lion_score = 0
        apeach_score = 0
        lion = [0] * 5

        for j in i:
            lion[j] += 1

        print(lion)
        lion[::-1]
        print(lion)

solution(5, [])
