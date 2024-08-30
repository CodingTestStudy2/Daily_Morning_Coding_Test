# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''


from collections import defaultdict
def solution(e, starts):
    #     counter = [0] * (e + 1)

    #     for i in range(1, e + 1):
    #         if i * i <= e:
    #             counter[i * i] += 1
    #         for j in range(i + 1, e // i + 1):
    #             n = i * j
    #             counter[n] += 2

    # def get_counts(e):
    # counter = defaultdict(int)

    # for i in range(1, e+1):
    #     if i*i < e+1:
    #         counter[i*i] += 1
    #     for j in range(i+1, e+1):
    #         n = i*j
    #         if n > e:
    #             break
    #         counter[n] += 2
    # return counter
    # counter = get_counts(e)
    counter = [0] * (e + 1)
    for i in range(1, e + 1):
        for j in range(i, e + 1, i):
            counter[j] += 1
    max_counter = [e] * (e + 1)

    for i in range(e - 1, 0, -1):
        if counter[i] >= counter[max_counter[i + 1]]:
            max_counter[i] = i
        else:
            max_counter[i] = max_counter[i + 1]

    return [max_counter[start] for start in starts]
