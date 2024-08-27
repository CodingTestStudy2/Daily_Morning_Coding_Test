'''
순위검색
'''

# 첫번째 풀이
# 정확하나, 효율성 0
def solution(info, query):
    answer = []
    
    for q in query:
        s = q.split() # query 분리하기
        result = list(filter(lambda x: (x.split()[0] == s[0] or s[0] == "-") and (x.split()[1] == s[2] or s[2] == "-") and (x.split()[2] == s[4] or s[4] == "-") and (x.split()[3] == s[6] or s[6] == "-") and int(x.split()[4]) >= int(s[7]), info))
        answer.append(len(result))
    
    return answer