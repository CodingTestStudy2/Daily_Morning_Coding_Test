'''
N마리 폰켓몬 중 N/2마리 가지기
최대로 다양한 종류의 폰켓몬 필요
[3, 3, 3, 2, 2, 4] 3마리 3종류
[3, 3, 3, 2, 2, 2] 3마리 2종류
'''

def solution(nums):
    setNums = set(nums)
    n = len(nums)
    answer = len(setNums) if n//2 > len(setNums) else n//2
    return answer