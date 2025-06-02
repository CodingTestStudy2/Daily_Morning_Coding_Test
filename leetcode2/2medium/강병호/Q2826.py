class Solution:
    def minimumOperations(self, nums: list[int]) -> int:
        # 맨앞에는 최대한 가장 작은 수
        '''
        i, j 기준으로 
        [0, i] -> 1s
        [i, j] -> 2s
        [j, n-1] -> 3s
        '''
        # TODO: O(n)으로 변경
        result = 100
        
        for i in range(0, len(nums)+1):
            for j in range(i, len(nums)+1):
                delCount = 0
                firstList = nums[0:i]
                secondList = nums[i:j]
                thridList = nums[j:]
                
                # print(f"firstList : {firstList}")
                # print(f"secondList : {secondList}")
                # print(f"thridList : {thridList}")
                
                delCount += len(firstList) - firstList.count(1)
                delCount += len(secondList) - secondList.count(2)
                delCount += len(thridList) - thridList.count(3)

                result = min(result, delCount)

        return result

if __name__ == "__main__":
    sol = Solution()
    print(sol.minimumOperations([1]))
    # print(sol.minimumOperations([2, 1, 3, 2, 1]))
    # print(sol.minimumOperations([1, 3, 2, 1, 3, 3]))
    # print(sol.minimumOperations([2, 2, 2, 2, 3, 3]))