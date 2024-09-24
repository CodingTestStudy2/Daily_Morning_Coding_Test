# https://school.programmers.co.kr/learn/courses/30/lessons/42885

def solution(people, limit):
    # 최소한의 구명보트 수 구하기, 최대 2명, 길이 제한
    answer = 0
    # 최소, 최대가 한팀
    left, right = 0, len(people)-1
    
    people.sort()
    
    while left <= right:
        if people[left] + people[right] <= limit:
            left += 1
        right -= 1
        answer += 1
        
    return answer