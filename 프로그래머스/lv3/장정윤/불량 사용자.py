def solution(user_id, banned_id):
    answer = 0
    # 경우의 수 가장 까다로운 것 부터 반영
    for i in range(len(banned_id)):
        arr = [k for k, value in enumerate(banned_id[i]) if value == '*']
        ans = []
        for k in range(len(user_id)):
            is_True = True
            long_len = max(len(user_id[k]), len(banned_id[i]))
            for j in range(long_len): 
                if j not in arr and user_id[k][j] != banned_id[i][j]:
                    is_True = False   
            if is_True:
                ans.append(user_id[k])
        if len(ans) == len(banned_id):           
            answer += 1
        # print(ans)
    return answer