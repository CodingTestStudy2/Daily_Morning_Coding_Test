# 슬라이딩 윈도우 사용했는데 안됨.. 토픽 보고 모노톤 스택 ? 을 공부함.

class Leetcode.이재훈.Solution:
    def maxSumMinProduct(self, nums: List[int]) -> int:
        n = len(nums)
        p_sum = [0] * (n+1) # 누적합
        for i in range(n):
            p_sum[i+1] = p_sum[i] + nums[i]
        
        print(p_sum) # [0, 1, 3, 6, 8]

        # 모노톤 스택 : 스택에 저장된 요소가 단조 증가 또는 단조 감소 상태를 유지하도록 설계된 자료 구조
        left = [-1] * n #각 요소에 자신보다 작은 값이 처음으로 나타나는 왼쪽 경계 찾기
        stack = []
        for i in range(n):
            while stack and nums[stack[-1]] >= nums[i]: # 스택의 top이 nums[i]보다 크면 pop
                stack.pop()
            if stack:
                left[i] = stack[-1] # 비어있지 않다면 top이 경계
            stack.append(i)
        # 경계 찾은 후에 최대 배열 최소값 구현해야함..
