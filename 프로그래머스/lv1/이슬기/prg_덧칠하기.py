'''
구현
'''

def solution(n, m, section):
    answer = 0
    paint = list(True for _ in range(n))
    
    for s in section:
        paint[s-1] = False
    
    for i in range(len(section)):
        if paint[section[i]-1]:
            continue
        
        paint[section[i]-1:section[i]-1+m] = list(True for _ in range(m))
        #print(paint)
        answer += 1
    
    return answer