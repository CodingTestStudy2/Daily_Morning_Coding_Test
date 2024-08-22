# https://school.programmers.co.kr/learn/courses/30/lessons/42890

from itertools import combinations

def solution(relation):
    num_keys = len(relation[0])
    answers = []
    for i in range(1, num_keys + 1):
        for comb in combinations(range(num_keys), i):
            tmp = []
            for key in relation:
                current = ()
                for value in comb:
                    current += (key[value],)
                tmp.append(current)
            if len(set(tmp)) == len(relation):
                is_minimal = True
                for answer in answers:
                    if set(answer).issubset(set(comb)):
                        is_minimal = False
                        break
                if is_minimal:
                    answers.append(comb)
    return len(answers)

solution([["100","ryan","music","2"],["200","apeach","math","2"],["300","tube","computer","3"],["400","con","computer","4"],["500","muzi","music","3"],["600","apeach","music","2"]])
