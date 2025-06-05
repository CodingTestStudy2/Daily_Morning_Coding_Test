import heapq
<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution:
=======
class Leetcode.이재훈.Solution:
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    def maximumElementAfterDecrementingAndRearranging(self, arr: List[int]) -> int:
        heapq.heapify(arr)  # min heap
        N = len(arr)
        heapq.heappop(arr)
        curr_max = 1
        for _ in range(1, N):
            curr_max = min(heapq.heappop(arr), curr_max + 1)
        return curr_max
