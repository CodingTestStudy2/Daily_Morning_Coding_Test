# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''

from collections import defaultdict
def solution(survey, choices):
    n = len(choices)
    graph = {"RT":0, "TR":1, "CF":2, "FC":3, "JM":4, "MJ":5, "AN":6, "NA":7}
    MBTI = [["R","T"], ["C","F"], ["J","M"], ["A","N"]]
    scores = [0] * 8

    for i in range(n):
        scores[graph[survey[i]]] += 4-choices[i]
    return "".join([MBTI[i][0] if scores[i*2] - scores[i*2+1]>=0 else MBTI[i][1] for i in range(4)])