class Solution:
    def minBitwiseArray(self, nums: List[int]) -> List[int]:
        ans = []
        for n in nums:
            if n % 2 == 0:
                ans.append(-1)
            else: 
                # 10  || 01 = 11 
                # 100 || 101 = 101
                # 110 || 111 = 111
                for x in range(n):
                    if (x | (x+1)) == n:
                        ans.append(x)
                        break
        return ans
