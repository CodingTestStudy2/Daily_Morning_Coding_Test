class Solution:
    def minProcessingTime(self, processorTime: List[int], tasks: List[int]) -> int:
        # 1개에 4코어 프로세서
        # sum(processTime + max task) 하면 execute 시간

        # task 정렬
        tasks.sort()

        # idx 크기 클수록 processorTime 낮게 잡아주기
        processorTime.sort(reverse=1)

        # print(tasks, processorTime)
        # 4개씩 끊어서 할당, [[], [], ...]

        result = 0

        for i in range(len(processorTime)):
            idx = i*4
            assign = tasks[idx:idx+4]
            time = processorTime[i] + max(assign)
            
            result = max(time, result)
            # print(assign, time)

        return result