def solution(s):
    answer = ''
    if len(s) % 2 == 0:
        print(len(s)//2)
        n = len(s)//2
        answer = s[n-1]+s[n]
    else:
        n = len(s)//2
        answer = s[n]
        
    return answer