def solution(s):
    answer = 1001
    if len(s) == 1: return 1

    for gap in range(1, len(s)//2+1):
        compressed, before, same_cnt = '', '', 1
        for j in range(0, len(s), gap):
            now = s[j:j+gap]
            if now != before:
                if same_cnt > 1: compressed += str(same_cnt) + before
                else: compressed += before
                same_cnt = 1
            else: same_cnt+=1
            before = now
            
        if same_cnt > 1: compressed += str(same_cnt)+before
        else: compressed += before
            
        # print(compressed)
        answer = min(answer, len(compressed))
            
    return answer