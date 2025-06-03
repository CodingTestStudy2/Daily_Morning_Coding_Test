import heapq
class Leetcode.이재훈.Solution:
    def maximumElementAfterDecrementingAndRearranging(self, arr: List[int]) -> int:
        heapq.heapify(arr)  # min heap
        N = len(arr)
        heapq.heappop(arr)
        curr_max = 1
        for _ in range(1, N):
            curr_max = min(heapq.heappop(arr), curr_max + 1)
        return curr_max
