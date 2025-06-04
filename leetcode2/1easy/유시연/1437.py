from typing import List

class Leetcode.이재훈.이재훈.Solution:
    def kLengthApart(self, nums: List[int], k: int) -> bool:
        n = len(nums)
        dis = 0
        found_first_one = False  

        for i in range(n):
            if nums[i] == 1:
                if not found_first_one:
                    found_first_one = True
                else:
                    if dis < k:
                        return False
                dis = 0 
            else:
                if found_first_one:
                    dis += 1

        return True
