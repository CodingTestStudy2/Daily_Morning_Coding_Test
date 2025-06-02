class Solution:
    def isPossibleToSplit(self, nums: list[int]) -> bool:
        # num1 = dict()
        # num2 = dict()

        # 1. length 동일
        # 2. 고유한 요소 존재 -> dict로 이미 존재하면 return False

        # maxLength = len(nums) // 2
        # nums.sort()

        # for num in nums:
        #     if len(num1) != maxLength and not num in num1:
        #         num1[num] = True
        #     elif len(num2) != maxLength and not num in num2:
        #         num2[num] = True
        #     else:
        #         print(f"num1 : {num1}")
        #         print(f"num2 : {num2}")
        #         print(f"num : {num}")
        #         return False
        
        # return True
        cntNum = dict()

        for num in nums:
            if not num in cntNum:
                cntNum[num] = 1
            elif cntNum[num] >= 2:
                return False
            else:
                cntNum[num] += 1
        return True

if __name__ == "__main__":
    sol = Solution()
    print(sol.isPossibleToSplit([2,10,2,7,8,9,7,6,6,9]))
    print(sol.isPossibleToSplit([1,1,1,1]))
    print(sol.isPossibleToSplit([1,2,3,4]))
    print(sol.isPossibleToSplit([1,2,1,2,1,2]))
    print(sol.isPossibleToSplit([8,9,8,5,9,3,3,1,2,1]))