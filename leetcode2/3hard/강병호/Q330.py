from itertools import combinations
import sys
 
sys.setrecursionlimit(3000)
class Solution:
    def minPatches(self, nums: list[int], n: int) -> int:
         # [1, n] 요소들 모두 형성하도록 처리
        setList = set(nums)
        def checkInclusiveList():
            # 조합생성
            # 시간 복잡도 줄일 방법
            # dp 처리
            sumList = set()
            combinationList = list()
            for i in range(1, len(nums)):
                for data in combinations(nums, i):
                    temp_sum = sum(data)
                    print(F"temp_sum : {temp_sum}")
                    setList.add(temp_sum)


            for i in range(1, n):
                if not i in setList:
                    return False
            
            return True

        def addPatch(n:int, cnt:int):
            if n in setList:
                addPatch(n+1, cnt)
            else:
                nums.append(n)
                cnt+=1            

            if checkInclusiveList():
                return cnt
            else:
                print(f"addPatch {cnt}")
                addPatch(n+1, cnt)


        return addPatch(n, 0)


if __name__ == "__main__":
    sol = Solution()
    print(sol.minPatches([1,3], 6))