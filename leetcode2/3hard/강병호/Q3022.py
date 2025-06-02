from math import sqrt

class Solution:
    def minOrAfterOperations(self, nums: list[int], k: int) -> int:
        # 1. 지수 구하기
        # 2. 지수 차 큰 것들 기준 k번 &연산처리
        sqrtList = list()
        # used 추가 필요
        for num in nums:
            sqrtList.append(int(sqrt(num)) + 1)
        print(f"sqrtList : {sqrtList}")
        
        diffSqrtList = list()

        for i in range(0, len(nums)-1):
            diffSqrtList.append((i, abs(sqrtList[i]-sqrtList[i+1])))
        print(f"diffSqrtList : {diffSqrtList}")
        
        diffSqrtList.sort(key = lambda x: -x[1]) # 내림차순 정렬

        delList = diffSqrtList[0:k]

        delList.sort(key = lambda x : -x[0])
        print(f"delList : {delList}")

        for delIndex in delList:
            index = delIndex[0]

            nums[index] = nums[index] & nums[index+1]

        result = nums[0]
        for i in range(1, len(nums)):
            result = result or nums[1]

        return result

    
if __name__ == "__main__":
    sol = Solution()
    print(sol.minOrAfterOperations([3,5,3,2,7], 2))