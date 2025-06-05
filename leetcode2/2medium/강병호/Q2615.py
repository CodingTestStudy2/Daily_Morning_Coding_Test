from collections import defaultdict

<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution:
=======
class Leetcode.이재훈.Solution:
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    def distance(self, nums: list[int]) -> list[int]:
        index_map = defaultdict(list)
        for i, num in enumerate(nums):
            index_map[num].append(i)
        
        n = len(nums)
        arr = [0] * n
        
        for data in index_map.values():
            m = len(data)
            if m > 1:
                prefix_sum = [0] * m
                prefix_sum[0] = data[0]
                
                for i in range(1, m):
                    prefix_sum[i] = prefix_sum[i - 1] + data[i]
                
                for i in range(m):
                    left_sum = prefix_sum[i - 1] if i > 0 else 0
                    right_sum = prefix_sum[-1] - prefix_sum[i]
                    arr[data[i]] = (i * data[i] - left_sum) + (right_sum - (m - i - 1) * data[i])
        
        return arr

