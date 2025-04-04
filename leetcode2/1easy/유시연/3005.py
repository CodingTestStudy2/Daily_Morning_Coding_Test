class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        count = {}

        for i in nums:
            if i in count:
                count[i] += 1
            else:
                count[i] = 1

        answer = 0
        for j in count.values():
            if j == max(count.values()):
                answer += j
            
        return answer
            