# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''


from collections import defaultdict
from bisect import bisect_left


def solution(info, query):
    bit_masks = []
    def backtrack(size):
        if size == 4:
            bit_masks.append(bit.copy())
            return
        bit.append(1)
        backtrack(size+1)
        bit[-1]=0
        backtrack(size+1)
        bit.pop()
    bit=[]
    backtrack(0)
    scores = defaultdict(list)

    def fill_scores_dict(info_):
        for bit_mask in bit_masks: #1,1,0,1...
            key=""
            for i in range(4):
                key += info_[i] if bit_mask[i] else "-"
            # print(key)
            scores[key].append(int(info_[-1]))

    for i in range(len(info)):
        info[i]=info[i].split(" ")
        fill_scores_dict(info[i])

    for k,v in scores.items():
        v.sort()

    ans=[]
    for i in range(len(query)):
        query[i] = query[i].replace(" and ","")
        key, val=query[i].split(" ")
        info_scores = scores[key]
        pos = bisect_left(info_scores, int(val))
        ans.append(len(info_scores)-pos)

    return ans
