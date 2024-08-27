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
"""
와.. 어케하냐면 

언어/직군/경력/푸드를 걍 싹 연결해서 고유 키로 생성하고
    (-인 경우 포함하기 위해 저 4개에서 - or not 즉 2^4 경우의 수로 키 생성해서 각 케이스에 점수 저장)
    (이진트리니까 이거 생성할때 백트래킹.. 근데 4승이라 크게 의미없을듯)

이걸로 info에 있는 애들 해싱해서 score를 value로 저장하고
쿼리 돌면서 쿼리할 점수 찾으면 됨(이때 이진탐색)

상상도 못한 정체다
"""
def solution(info, query):
    from collections import defaultdict
    from bisect import bisect_left

    def generate_bit_mask() -> list:
        bit_masks = []
        def backtrack(size):
            print(f"backtrack({size})")
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
        return bit_masks
    
    bit_masks = [[1, 1, 1, 1], [1, 1, 1, 0], 
                 [1, 1, 0, 1], [1, 1, 0, 0], 
                 [1, 0, 1, 1], [1, 0, 1, 0], 
                 [1, 0, 0, 1], [1, 0, 0, 0], 
                 [0, 1, 1, 1], [0, 1, 1, 0], 
                 [0, 1, 0, 1], [0, 1, 0, 0], 
                 [0, 0, 1, 1], [0, 0, 1, 0], 
                 [0, 0, 0, 1], [0, 0, 0, 0]]
    
    score_dict = defaultdict(list)
    for info_ in info:
        info_ = info_.split()
        for bit_mask in bit_masks:
            key = ""
            for i in range(4):
                key += info_[i] if bit_mask[i] else "-"
            score_dict[key].append(int(info_[-1]))
    print(score_dict)
    
    for _, v in score_dict.items(): v.sort()

    answer = []
    for q in query:
        key, score = q.replace(" and ", "").split()
        info_score = score_dict[key]
        uncoditioned_num = bisect_left(info_score, int(score))
        answer.append(len(info_score) - uncoditioned_num)
    return answer

    
    
    