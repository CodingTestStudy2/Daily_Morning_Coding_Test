class Solution:
    def maxSum(self, nums: list[int]) -> int:
        # 최대 합
        # 1. 완전탐색 : -100 ~ 100 존재하면 합
        # 2. set으로 생성
        # 최대합이니 음수는 최대한 안더하기
        result = 0
        uniqueDict = sorted(list(set(nums)), reverse=True)
        # sortedDict = uniqueDict.sort(reversed = True)
        # print(uniqueDict)
        for i in range(len(uniqueDict)):
            if i == 0 and uniqueDict[i] <= 0:
                result += uniqueDict[i]
            elif uniqueDict[i] <= 0:
                break
            else:
                result += uniqueDict[i]
    
        return result

if __name__== "__main__":
    sol = Solution()
    print(sol.maxSum([5, 4, 3, 2, 1]))
    print(sol.maxSum([1,2,-1,-2,1,0,-1]))
    print(sol.maxSum([-1]))
        