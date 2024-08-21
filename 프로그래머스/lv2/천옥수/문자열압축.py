def solution(s):
    answer = len(s)
    for skip in range(1,len(s)//2 + 1):
        cnt = 1
        compressed = s[:skip]

        for idx in range(0, len(s)-skip, skip): # 0, 8-1, 1

            curr= s[idx: idx+skip]
            nxt = s[idx+skip : idx + 2* skip]
            if (len(s)== 1) :
                print(curr)

            if curr == nxt :
                if cnt == 1:
                    compressed = compressed[:-skip]
                if cnt > 1:
                    compressed = compressed[:- (len(str(cnt)) + skip)]
                cnt+=1
                compressed += str(cnt) + nxt
            else:
                compressed += nxt
                cnt = 1
        answer = min(len(compressed), answer)
        # print(f"{skip=}")
        # print(f"{compressed=}")
    return answer