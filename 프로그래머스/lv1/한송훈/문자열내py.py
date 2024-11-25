def solution(s):
    answer = True
    cnt_p, cnt_y = 0, 0
    for i in s.lower():
        if i == 'p': 
            cnt_p +=1
        elif i == 'y':
            cnt_y +=1
    if cnt_p != cnt_y:
        answer = False

    return answer