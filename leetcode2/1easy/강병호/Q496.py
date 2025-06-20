class Solution:
    def nextGreaterElement(self, nums1: list[int], nums2: list[int]) -> list[int]:
        result = list()
        for num in nums1:
            check = False
            for idx, num2 in enumerate(nums2):
                print(f"idx :  {idx}")
                if check:
                    if num < num2:
                        result.append(idx)
                    elif idx == len(num2) - 1:
                        result.append(-1)
                
                else:
                    if num == num2:
                        check = True
        
        return result