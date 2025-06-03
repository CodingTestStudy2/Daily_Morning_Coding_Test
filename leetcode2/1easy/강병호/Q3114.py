class Leetcode.이재훈.Solution:
    def findLatestTime(self, s: str) -> str:
        # i - 0 : i - 1과 연관 / 3이상이면 무조건 0
        # i - 1 : i - 0과 연관 / 1이면 0~2
        time = list(s)

        t0, t1 = time[0], time[1]
        

        if t0 == '?':
            if t1 == '?':
                t0 = '1'
            else:
                t0 = '1' if int(t1) <= 1 else '0'
        
        time[0] = t0

        if t1 == '?':
            t1 = '1' if time[0] == '1' else '9'
        time[1] = t1

        t3, t4 = time[3], time[4]
        if t3 == '?':
            t3 = '5'
        time[3] = t3
        
        if t4 == '?':
            t4 = '9'
        time[4] = t4

        return ''.join(time)

        

