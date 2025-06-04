from itertools import combinations
class Leetcode.이재훈.이재훈.Solution:
    def lengthOfLongestSubsequence(nums, target) -> int:
        # dp 같은데 구현 못했다..
        nums.sort(reverse=True) # 큰 수부터 (최대를 구하니까)

        ans = -1
        for k in range(1, len(nums)+1):
            for i in combinations(nums, k):
                if sum(i) == target:
                    if len(i)>ans: ans = len(i)

        if ans == 0: return -1
    
    lengthOfLongestSubsequence([1000], 1000)
