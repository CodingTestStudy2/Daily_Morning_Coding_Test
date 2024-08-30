# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''


def solution(today, terms, privacies):
    term_dict = {}
    for term in terms:
        key, val = term.split(" ")
        term_dict[key] = int(val) * 28

    def serialize(ymd):
        y,m,d = ymd.split(".")
        return int(y)*12*28 + int(m)*28 + int(d)

    today = serialize(today)

    ans=[]
    for i, privacy in enumerate(privacies):
        date, term = privacy.split(" ")
        if serialize(date) + term_dict[term] <= today:
            ans.append(i+1)
    return ans