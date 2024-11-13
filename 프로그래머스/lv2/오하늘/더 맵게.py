import heapq
def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    
    while len(scoville) > 1 and scoville[0] < K:
        fst = heapq.heappop(scoville)
        sec = heapq.heappop(scoville)
        if len(scoville) == 0 and fst+(sec*2) < K:
            return -1
        heapq.heappush(scoville, fst+(sec*2))
        answer += 1

    else : return answer

print(solution([1, 2, 3], 45))