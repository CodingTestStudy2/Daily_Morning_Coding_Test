'''
데이터 분석
'''

def solution(data, ext, val_ext, sort_by):
    answer = [[]]
    column = ["code", "date", "maximum", "remain"]
    
    for i in range(4):
        if ext == column[i]:
            answer = list(filter(lambda x: x[i] < val_ext, data))
    
    for j in range(4):
        if sort_by == column[j]:
            answer = sorted(answer, key=lambda x: x[j])
    
    return answer