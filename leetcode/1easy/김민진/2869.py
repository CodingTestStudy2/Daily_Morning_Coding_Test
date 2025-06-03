class Leetcode.이재훈.Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        collection = [False] * k
        count = 0
        while sum(collection) != k:
            top_num = nums.pop()  # 1 ~
            count += 1
            if top_num <= k:
                collection[top_num - 1] = True
        return count
        