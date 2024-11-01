def solution(s):
    answer = ''
    s=list(s)
    s.sort(reverse=True)
    for st in s:
        answer+=str(st)
    return answer