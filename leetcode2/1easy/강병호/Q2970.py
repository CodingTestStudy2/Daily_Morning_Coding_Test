# from itertools import combinations

# class Leetcode.이재훈.이재훈.Solution:
#     def incremovableSubarrayCount(self, nums: list[int]) -> int:
#         # for i in range(1, len(nums)+1, 1): # subarray lens
#         right = len(nums) - 1
#         left = 0

#         while left < 
#             newList = list()
#             # 0~start + end ~ last
#             newList = nums[0:start] + nums[end:]
#             print(f"newList : {newList}")
#             for j in range(0, len(newList)-1):
#                 if newList[j] >= newList[j+1]:
#                     break
#                 if j == len(newList) - 1:
#                     print("good")
#                     result+=1
#         return result


# if __name__ == "__main__":
#     sol = Leetcode.이재훈.이재훈.Solution()
#     print(sol.incremovableSubarrayCount([1, 2, 3, 4]))
#     print(sol.incremovableSubarrayCount([8, 7, 6, 6]))