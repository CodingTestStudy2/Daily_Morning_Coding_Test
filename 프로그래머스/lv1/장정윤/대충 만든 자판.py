def solution(keymap, targets):
    # 1번 키부터 차례대로 할당된 문자들이 순서대로 배열 keymap
    # 입력하려는 문자열들이 담긴 문자열 배열 targets
    # 최소 몇번 눌러야하는지 계산해서 answer에 추가
    answer = []
    allAlpha = {}
    
    for key in keymap:
        cnt  = 0
        for i in range(len(key)):
            if key[i] in allAlpha:
                allAlpha[key[i]] = min(allAlpha[key[i]], i+1)
            else:
                allAlpha[key[i]] = i + 1
    for target in targets:
        result = 0
        for char in target:
            if char in allAlpha:
                result += allAlpha[char]
            else:
                result = -1
                break # 더 이상 계산하지 않고 루프를 종료
        answer.append(result)
    return answer