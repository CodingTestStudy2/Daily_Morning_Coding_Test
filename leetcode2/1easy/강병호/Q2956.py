class Solution:
    def findIntersectionValues(self, nums1: list[int], nums2: list[int]) -> list[int]:
        answer1, answer2 = 0, 0

        for num in nums1:
            if num in nums2:
                answer1 +=1
        
        for num in nums2:
            if num in nums1:
                answer2 += 1
        
        return [answer1, answer2]