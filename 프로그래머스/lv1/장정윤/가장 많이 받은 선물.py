def solution(friends, gifts):
    n = len(friends)
    dic_give, dic_get = {}, {}
    table = [[0] * n for _ in range(n)]
    name_idx = {friends[i]: i for i in range(n)}

    for gift in gifts:
        giver, getter = gift.split()
        giver_idx = name_idx[giver]
        getter_idx = name_idx[getter]
        table[giver_idx][getter_idx] += 1  # giver가 getter에게 준 선물
        
        dic_give[giver] = dic_give.get(giver, 0) + 1  # 선물 준 횟수
        dic_get[getter] = dic_get.get(getter, 0) + 1  # 선물 받은 횟수
    
    # 다음 달에 누가 가장 많은 선물을 받을지 계산 (선물 지수: 토탈 준 수 - 토탈 받은 수)
    gift_indices = [dic_give.get(f, 0) - dic_get.get(f, 0) for f in friends]
    get_gift = [0] * n

    for i in range(n):
        for j in range(n):
            if i == j:
                continue
            # i와 j 친구 간에 선물을 주고받은 횟수
            if table[i][j] > table[j][i]:  # i가 j에게 더 많이 준 경우
                get_gift[i] += 1
            elif table[i][j] == table[j][i]:  # 주고받은 횟수가 같은 경우
                if gift_indices[i] > gift_indices[j]:  # 선물 지수가 높은 경우
                    get_gift[i] += 1
    answer = max(get_gift)
    return answer