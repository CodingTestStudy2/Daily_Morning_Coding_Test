<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution:
=======
class Leetcode.이재훈.Solution:
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    def minimumSum(self, nums: list[int]) -> int:
        result = -1
        for idx in range(1, len(nums)-1): # mid-num
            left, right = 1, 1
            while idx - left != -1:
                # print(f"idx + right : {idx + right}")
                # print(f"idx + left : {idx - left}")
                if nums[idx] > nums[idx-left] and nums[idx] > nums[idx+right]:
                    sumNum = nums[idx] + nums[idx-left] + nums[idx+right]
                    if result == -1 or sumNum < result:
                        result = sumNum
                
                if idx + right == len(nums) - 1:
                    right = 1
                    left += 1
                else:
                    right += 1
                
            
        
        return result


if __name__ == "__main__":
<<<<<<< HEAD
    sol = Leetcode.이재훈.이재훈.Solution()
=======
    sol = Leetcode.이재훈.Solution()
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    print(sol.minimumSum([8, 6, 1, 5, 3]))
    print(sol.minimumSum([6,5,4,3,4,5]))
    print(sol.minimumSum([5,4,8,7,10,2]))
