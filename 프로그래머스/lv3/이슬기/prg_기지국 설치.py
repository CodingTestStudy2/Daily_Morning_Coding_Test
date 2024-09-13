'''
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
-> 4, 11
슬라이딩 윈도우?

-- 다시
stations 기준으로 왼쪽에 있는 기지국 개수 구하기
'''

def solution(n, stations, w):
    answer = 0
    
    for i in range(len(stations)):
        if i == 0:
            now = stations[i] - w - 1
            if now > 0:
                remain = now % (w*2+1)
                if remain > 0:
                    answer += 1
                if now // (w*2+1) > 0:
                    answer += now // (w*2+1)
        else:
            now = stations[i] - stations[i-1] - 1 - w*2
            remain = now % (w*2+1)
            if now > 0:
                if remain > 0:
                    answer += 1
                if now // (w*2+1) > 0:
                    answer += now // (w*2+1)
        #print(i, answer)
    
    now = n - stations[-1] - w
    if now > 0:
        remain = now % (w*2+1)
        if remain > 0:
            answer += 1
        if now // (w*2+1) > 0:
            answer += now // (w*2+1)

    return answer