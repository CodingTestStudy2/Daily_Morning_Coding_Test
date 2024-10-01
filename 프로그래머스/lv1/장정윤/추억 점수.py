# https://school.programmers.co.kr/learn/courses/30/lessons/176963
# 10분
def solution(name, yearning, photo):
    answer = []
    match = {}
    # name, yearing으로 dic 생성
    # photo[idx] 매칭 되는 합산 리턴
    
    for idx, word in enumerate(name):
        match[word] = yearning[idx]
        
    for item_list in photo:
        cnt = 0
        for idx, item in enumerate(item_list):
            if item in match.keys() and match[item]:
                cnt += match[item]
        answer.append(cnt)
        
    return answer