'''
k번째 이내이면 명예의 전당에 올림
-> 가장 낮은 점수 발표!
'''
import heapq

def solution(k, score):
    answer = []
    pq = []
    
    for one in score:
        heapq.heappush(pq, one)
        
        if len(pq) > k:
            heapq.heappop(pq)
        
        answer.append(pq[0])
    
    return answer