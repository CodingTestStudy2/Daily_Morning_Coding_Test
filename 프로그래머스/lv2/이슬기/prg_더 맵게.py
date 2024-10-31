'''
가장 매운 스코빌 지수 + 두번째 스코빌 지수
heapq으로 구현
'''

import heapq

def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    
    while scoville:
        now = heapq.heappop(scoville)
        if now < K:
            if not scoville:
                return -1
            next = heapq.heappop(scoville)
            new = now + next * 2
            heapq.heappush(scoville, new)
            answer += 1
        else:
            return answer