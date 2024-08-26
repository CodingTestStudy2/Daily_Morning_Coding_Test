from itertools import combinations_with_replacement


def solution(n, info):
    answer = [-1]
    lion_arrow = list(combinations_with_replacement(range(0, 11), n))
    max_diff = 0

    for lion in lion_arrow:
        lion = list(lion)
        lion_score = 0
        apeach_score = 0

        for k in range(0, 11):
            if info[k] < lion[k]:
                lion_score += (10 - k)
            else:
                apeach_score += (10 - k)

        if max_diff < lion_score - apeach_score:
            max_diff = lion_score - apeach_score
            answer = rion

    return answer