'''
구현
'''

def solution(dartResult):
    answer = 0
    score = 0
    result = [0] * 3
    op = -1
    
    for d in dartResult:
        if 48 <= ord(d) < 58:
            if score == 1 and d == '0':
                score = 10
            else:
                op += 1
                score = int(d)
            result[op] = score
        
        if d in ['S', 'D', 'T']:
            if d == 'D':
                result[op] = result[op] ** 2
            elif d == 'T':
                result[op] = result[op] ** 3
        
        if d in ['*', '#']:
            if d == '*':
                result[op] *= 2
                if op > 0:
                    result[op-1] *= 2
            elif d == '#':
                result[op] *= -1
    
    answer = sum(result)
    
    return answer