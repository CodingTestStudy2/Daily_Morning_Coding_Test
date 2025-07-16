class Solution:
    def minProcessingTime(self, processorTime: List[int], tasks: List[int]) -> int:
        n = len(processorTime)
        tasks.sort(reverse = True)
        processorTime.sort()
        result = 0

        for i in range(n):
            start = processorTime[i]
            for j in range(4):
                result = max(result, start + tasks[j + 4 *i])

        
        return result