
'''
1. 아이디어 :
주어진 배열에서 각 요소에 대해 가장 작은 비트wise OR 값을 찾는다.

2. 시간복잡도 :
o(n^2)

3. 자료구조/알고리즘 :
'''

class Solution:
    def minBitwiseArray(self, nums: List[int]) -> List[int]:
        n = len(nums)
        ans = [-1] * n
        for i in range(n):
            for j in range(nums[i]):
                if j | j+1 == nums[i]:
                    ans[i] = j
                    break

        return ans

                                
                    