from collections import deque

def solution(bridge_length, weight, truck_weights):
    answer = 0
    q = deque() # [트럭 무게, 현재 시간]
    total_weight = 0  # 다리에 있는 트럭 합
    
    while truck_weights or q:  # 대기 트럭이 남아있거나 다리에 트럭이 있으면
        answer += 1  # 시간 증가
        
        # 건넌 트럭 처리
        if q and q[0][1] + bridge_length == answer:  # 경과 시간이 다리 길이만큼 지난 경우
            total_weight -= q.popleft()[0]
        
        # 새로운 트럭 올리기
        if truck_weights and total_weight + truck_weights[0] <= weight: # 트럭 합과 새로운 weight의 합이 weight 보다 작으면
            truck = truck_weights.pop(0)
            q.append((truck, answer))  # 큐에 트럭 무게와 현재 시간 추가
            total_weight += truck
            
    return answer