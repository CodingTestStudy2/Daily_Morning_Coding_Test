from collections import deque

def solution(order):
    answer = 0
    main_q = deque(order) # 오더
    sub_q = deque() # 보조
    
    for i in range (1, len(order)+1): # 번호가 증가하는 순서대로 컨테이너 벨트에 일렬
        if i == main_q[0]: # 순서와 오더가 같으면
            main_q.popleft()
            answer+=1
        else:
            while sub_q and sub_q[0] == main_q[0]: # 보조 컨베이어 벨트에 있으면 출력
                sub_q.popleft()
                main_q.popleft()
                answer += 1
            sub_q.appendleft(i)
            
    while sub_q and sub_q[0] == main_q[0]: # 보조 한번 더 체크
        sub_q.popleft()
        main_q.popleft()
        answer += 1
    
    return answer


print(solution([4, 3, 1, 2, 5]))