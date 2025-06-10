class Solution:
    def countTime(self, time: str) -> int:
        # 가능한 시간
        h1, h2, m1, m2 = time[0], time[1], time[3], time[4]

        # h1 ~ h2
        # m1 ~ m2
        # if '?' not in [h1, h2, m1, m2]:
        #     return 1

        result = 1

        if h1 == '?':
            if h2 == '?':
                result *= 24
            elif int(h2) < 4 :
                # h1 : 0, 1, 2
                result *= 3
            else:
                # h1 : 0, 1
                result *= 2
        elif int(h1) in [0, 1]:
            if h2 == '?':
                result *= 10
        elif int(h1) == 2:
            if h2 == "?":
                result *= 4
        
        # minute

        if m1 == '?':
            result *= 6
        
        if m2 == '?':
            result *= 10
        
        return result

