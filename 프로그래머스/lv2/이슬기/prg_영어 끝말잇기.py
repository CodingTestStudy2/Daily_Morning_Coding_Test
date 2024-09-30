'''
n명의 사람
끝말잇기 단어 HashMap에 저장
{"tank" : 1, "kick": 2, ... }
1. 이미 사전에 있으면 탈락
2. 마지막 문자로 시작하지 않는 단어면 탈락
'''
from collections import defaultdict

def solution(n, words):
    word_dict = defaultdict(int)
    last_word = ""
    fail = [0, 0]
    turn = 0
    for i in range(len(words)):
        if (i % n) == 0:
            turn += 1
        
        if words[i] in word_dict:
            fail = [(i % n) + 1, turn]
            break
        if i != 0 and last_word != words[i][0]:
            fail = [(i % n) + 1, turn]
            break
        
        word_dict[words[i]] = (i % n) + 1 # 사전에 넣기
        last_word = words[i][-1]
    
    return fail