'''
원하는 단어가 배열에 있는지?
-> 서로 다른 단어만 있음
'''

def solution(cards1, cards2, goal):
    answer = "Yes"
    cnt1, cnt2 = 0, 0
    
    for g in goal:
        if cnt1 < len(cards1) and g == cards1[cnt1]:
            cnt1 += 1
        elif cnt2 < len(cards2) and g == cards2[cnt2]:
            cnt2 += 1
        else:
            answer = "No"
            break
    
    return answer