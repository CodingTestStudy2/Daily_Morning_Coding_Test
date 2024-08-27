# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''


def solution(data, ext, val_ext, sort_by):
    #수량, 제조일 최대수량, 현재 수량
    word_map = {"code":0, "date":1, "maximum":2, "remain":3}
    return sorted([d for d in data if d[word_map[ext]] < val_ext], key=lambda x: x[word_map[sort_by]])