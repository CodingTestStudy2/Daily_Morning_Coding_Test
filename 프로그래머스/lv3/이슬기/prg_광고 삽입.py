'''
공익광고 위치
1. logs에서 시작하는 위치 or 00:00:00 에서 시작
2. 모든 시청 구간 표시
'''
def solution(play_time, adv_time, logs):
    
    def getSeconds(x):
        t = x.split(":")
        return int(t[0]) * 60 * 60 + int(t[1]) * 60 + int(t[2])
    
    def getTimes(x):
        hh = str(x // 3600).zfill(2)
        mm = str((x % 3600) // 60).zfill(2)
        ss = str(x % 60).zfill(2)
        return f"{hh}:{mm}:{ss}"
    
    play_t = getSeconds(play_time)
    adv_t = getSeconds(adv_time)
    time_mov = [0] * (play_t + 1)
    
    for log in logs:
        start = getSeconds(log.split("-")[0])
        end = getSeconds(log.split("-")[1])
        time_mov[start] += 1
        if end <= play_t:
            time_mov[end] -= 1
    
    for i in range(1, play_t):
        time_mov[i] += time_mov[i-1]
    
    window = sum(time_mov[:adv_t])
    max_time = window
    start_time = 0
    
    for i in range(adv_t, play_t):
        window += time_mov[i] - time_mov[i-adv_t]
        if max_time < window:
            max_time = window
            start_time = i - adv_t + 1
    
    return getTimes(start_time)