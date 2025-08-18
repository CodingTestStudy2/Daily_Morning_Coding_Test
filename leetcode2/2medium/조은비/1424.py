class Solution:
    def findDiagonalOrder(self, nums: List[List[int]]) -> List[int]:
        # stack에 느어야하나.
        # 세로: 0/1,0/2,1,0/3,2,1,0 ...
        # 가로: 0/0,1/0,1,2/0,1,2,3 ...

        keep = []
    
        n = len(nums)
        for i in range(n):
            m = len(nums[i])
            for k in range(m):
                print(i,k, nums[i][k])
                if i+k == len(keep):
