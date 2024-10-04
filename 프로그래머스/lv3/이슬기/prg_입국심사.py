'''
심사시간 더 짧은 곳에서 심사받기
=> 가장 짧은 심사시간을 찾아라
=> "심사시간"을 이분탐색해서 찾기
'''

def solution(n, times):
    times.sort()
    left, right = 1, times[-1] * n # right : 가장 비효율적인 심사시간
    answer = right
    while left <= right:
        mid = (left + right) // 2
        complete_person = 0 # mid 시간 내에 심사 완료한 사람
        
        for t in times:
            complete_person += mid // t
            if complete_person >= n:
                break
        # 심사 완료한 사람 >= 심사할 사람
        if complete_person >= n:
            answer = min(mid, answer)
            right = mid - 1
        else:
            left = mid + 1
    
    return answer