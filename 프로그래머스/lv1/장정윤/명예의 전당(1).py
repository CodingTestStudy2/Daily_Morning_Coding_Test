def solution(k, score):
    answer = []
    prize = []
    # k순위 값 보다 높으면 명예의 전당에 오르게 된다. 이전 k순의 값은 아웃
    # 업데이트 된 명예의 전당 최하위 점수 append
    
    for idx, num in enumerate(score):
        prize.append(score[idx])
        prize = sorted(prize, reverse=True)[:k]
        answer.append(prize[-1])
    
    return answer