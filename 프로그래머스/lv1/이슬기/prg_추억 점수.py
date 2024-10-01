'''
그리움 점수.. 주는 대로 풀면 될 듯
'''

def solution(name, yearning, photo):
    answer = []
    
    for one in photo:
        score = 0
        for i in range(len(one)):
            try:
                idx = name.index(one[i]) # index error 나면 무시
                score += yearning[idx]
            except:
                continue
        answer.append(score)
    
    return answer