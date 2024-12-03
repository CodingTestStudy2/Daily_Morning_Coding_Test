'''
겹치는 시간을 세어서 최댓값 구하기
'''

def solution(book_time):
    answer = 0
    MAX_TIME = 24 * 60 # 모든 분 타임라인
    HOUR = 60
    timeline = [0] * (MAX_TIME + 10) # 10분간 청소를 해야하므로 +10
    
    def getMinutes(ti):
        clock_list = list(map(int, ti.split(":")))
        return clock_list[0] * HOUR + clock_list[1]
    
    for t in book_time:
        start_mm = getMinutes(t[0])
        end_mm = getMinutes(t[1])
        for i in range(start_mm, end_mm + 10):
            timeline[i] += 1
    
    answer = max(timeline)
    
    return answer