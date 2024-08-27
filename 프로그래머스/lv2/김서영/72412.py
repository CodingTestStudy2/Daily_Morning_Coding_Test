"""
0"java backend junior pizza 150",
1"python frontend senior chicken 210",
2"python frontend senior chicken 150",
3"cpp backend senior pizza 260",
4"java backend junior chicken 80",
5"python backend senior chicken 50"]

"java and backend and junior and pizza 100"
(0,4)   (0,3,4,5)    (0,4)      (0)    (0,1,2,3)
"""
def solution_without_efficiency(info, query):
    from collections import Counter
    
    answer = []
    table = [i.split() for i in info]
    
    for q in query:
        q = q.split()
        q = [q[0], q[2], q[4], q[6], q[7]]
        
        satisfied = []
        for i in range(4):
            if q[i] == '-':
                satisfied += [x for x in range(len(info))]
            else:
                satisfied += [idx for idx, record in enumerate(table) if record[i] == q[i]]
        if q[4] == '-':
            satisfied += [x for x in range(len(info))]
        else:
            satisfied += [idx for idx, record in enumerate(table) if int(record[4]) >= int(q[4])]
        
        satisfied_cnt = 0
        for _, cnt in Counter(satisfied).items():
            if cnt == 5: satisfied_cnt += 1
        answer.append(satisfied_cnt)
    return answer


# 효율 박살.. 당연함
# 첫 언어 조건 만족하는 레코드 기준으로 나머지 쿼리 기준 검사하면 더 최적화할 수 있겠다
# table 자체를 tranpose 해서 columnar로 접근해보자
def solution_still_inefficient(info, query):
    answer = []
    table = list(zip(*[i.split() for i in info]))
    
    for q in query:
        q = q.split()
        q = [q[0], q[2], q[4], q[6], q[7]]
        # 언어 조건 만족하는 지원자 인덱스로 초기화
        satisfied = [i for i, lang in enumerate(table[0]) if lang==q[0] or q[0] == '-'] 
        for i in range(1, 4):
            if q[i] == '-': continue
            satisfied = [s for s in satisfied if table[i][s] == q[i]]
        satisfied = [s for s in satisfied if int(table[4][s]) >= int(q[4]) or q[4] == '-']
        answer.append(len(satisfied))
    return answer
    
    
# 와... 이래도 시간초과나네
# 해싱해야될듯 근데 어케함?
def solution(info, query):
    dict = [
        {'cpp': set(), 'java': set(), 'python': set()},
        {'backend': set(), 'frontend': set()},
        {'junior': set(), 'senior': set()},
        {'chicken': set(), 'pizza': set()}
    ]
    for i in info:
        lang, occu, career, food, score = i.split()
        
    
    