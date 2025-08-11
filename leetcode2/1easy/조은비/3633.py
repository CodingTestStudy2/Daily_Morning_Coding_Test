class Solution:
    def earliestFinishTime(self, landStartTime: List[int], landDuration: List[int], waterStartTime: List[int], waterDuration: List[int]) -> int:
        # t + duration 에 내림
        result = 0
        while len(landStartTime) > 0 or len(waterStartTime) > 0:
            
            l = landStartTime[0]
            w = waterStartTime.pop()
            # if landStart
            print(l, w)

        # 결과에 따라 
        # next_t = 0
        # next_t += Duration[0]

        # 를 반복...
        
        return result
        

        # for i, l in enumerate(landStartTime):
        #     print(l, landDuration[i], '->', l + landDuration[i])
        #     next_t = l + landDuration[i]
            
        #     # 저 합이 다음 land or water의 StartTime 보다 작아야함
        #     for k, w in enumerate(waterStartTime):
        #         if next_t <= w:
        #             next_t = min(next_t, w)
        #             print(w, waterDuration[k], '->', w + waterDuration[k])

        # return result
        