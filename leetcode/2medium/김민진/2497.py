import heapq

class Solution:
    def maxStarSum(self, vals: List[int], edges: List[List[int]], k: int) -> int:
        adj_dict = dict()
        for i, val in enumerate(vals):
            adj_dict[(i, val)] = []
        for a, b in edges:
            # add both directions
            adj_dict[(a, vals[a])].append(-vals[b]) # to make it max heap
            adj_dict[(b, vals[b])].append(-vals[a])

        max_sum = -1e4
        for key, values in adj_dict.items():
            heapq.heapify(values)
            _sum = key[1]
            for _ in range(min(k, len(values))):
                popped_max = (-1 * heapq.heappop(values))
                if popped_max > 0:  # prevent adding a neg int
                    _sum += popped_max
            if _sum > max_sum:
                max_sum = _sum
        return max_sum