'''
반환시간을 최소화해주는 스케줄러
-> 우선순위 스케줄링을 구현 (비선점)
'''
import heapq

def solution(jobs):
    jobs.sort()
    total = sum(map(lambda x: x[0] + x[1], jobs)) # 모든 요청 처리시간
    time = 0
    now = []
    q = []
    res = []
    
    while time <= total:
        while jobs:
            if jobs[0][0] == time:
                process = jobs.pop(0)
                heapq.heappush(q, (process[1], process[0])) # 소요 시간, 시작 시간
            else:
                break
        
        # print(f"now {now} time {time}")
        
        if not now or now[0] == 0: # 새로 job을 할당해줘야 함
            if now:
                res.append(time - now[1])
                now = []
            
            if q:
                p = heapq.heappop(q)
                # print(p)
                now = []
                now.append(p[0]-1)
                now.append(p[1])
            else:
                if not jobs: # 남은 job이 없을 경우
                    break
        else:
            now[0] -= 1
        
        time += 1
    
    return sum(res) // len(res)