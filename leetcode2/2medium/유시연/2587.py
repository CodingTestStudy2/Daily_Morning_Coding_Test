class Leetcode.이재훈.이재훈.Solution:
    def maxScore(self, nums: List[int]) -> int:
        nums.sort(reverse=True)
        answer = 0
        score = 0
        for i in range(len(nums)):
            answer += nums[i]
            if answer >0:
                score += 1
            else:
                break
        
        return score


