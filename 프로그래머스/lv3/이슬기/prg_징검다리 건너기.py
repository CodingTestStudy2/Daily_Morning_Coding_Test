'''
완탐하면 쉬운 문제.. but stones배열 원소 값 때문에 시간초과날 듯
[2, 4, 5, 3, 2, 1, 4, 2, 5, 1]
한 자리부터 +k범위 안에 있는 수 중, 해당 자리보다 작은 원소밖에 없다면
 X  X  2  X  X  X  X
 -> 해당 자리에서부터 건널 수 없음
[1, 2, 3, 4] 오름차순인 경우? -> 뒤로 한 번 더ㅎ..
 X  X  X  X
 
정확도 100, 시간초과 난 코드
'''

def solution(stones, k):
    answer = max(stones)
    n = len(stones)
    
    for i in range(n-k):
        left, right = i, i+k
        maxValue = 1e9 # 차이나는 수
        pos = 0 # 자릿수
        for j in range(k):
            now = stones[left+j+1]
            if stones[left] < now:
                maxValue = -1 # 더 큰 수가 있다면, 끝
                break
            
            if 0 <= stones[left] - now < maxValue:
                maxValue = stones[left] - now
                pos = now
        if maxValue >= 0:
            answer = min(answer, pos)
        
        maxValue = 1e9
        pos = 0
        for l in range(k):
            now = stones[right-l-1]
            if stones[right] < now:
                maxValue = -1 # 더 큰 수가 있다면, 끝
                break
            
            if 0 <= stones[right] - now < maxValue:
                maxValue = stones[right] - now
                pos = now
        if maxValue >= 0:
            answer = min(answer, pos)
    
    return answer