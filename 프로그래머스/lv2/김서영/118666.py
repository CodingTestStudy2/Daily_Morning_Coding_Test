'''["AN", "CF", "MJ", "RT", "NA"]
    5       3    2      7     5
-4  1       -1   -2     3     1   -> N+1 C+1 M+2 T+3 A+1
    1       1    1      1     1
    -3      -3  -3      -3     -3
    
'''
def solution(survey, choices):
    type_score = {'T':0, 'R':0, 'C':0, 'F':0, 'J':0, 'M':0, 'A':0, 'N':0}
    choices = [x-4 for x in choices] # [1, -1, -2, 3, 1]
    
    for s, c in zip(survey, choices):
        if c < 0:
            type_score[s[0]] -= c
        else:
            type_score[s[1]] += c
            
    type_lst = []
    for t in ['RT', 'CF', 'JM', 'AN']:
        if type_score[t[0]] >= type_score[t[1]]:
            type_lst.append(t[0])
        else:
            type_lst.append(t[1])
    
    return ''.join(type_lst)

