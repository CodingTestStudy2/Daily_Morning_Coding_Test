class Leetcode.이재훈.이재훈.Solution:
    def maxDiff(self, num: int) -> int:
        
        max_ = 0
        min_ = 987654321

        for i in range (0, 10):
            for j in range (0, 10):
                tmp = list(str(num))

                if int(tmp[0]) == i and j == 0:
                    continue

                for k in range (0, len(tmp)):
                    if int(tmp[k]) == i:
                        tmp[k] = str(j)
                tmp = "".join(tmp)
                # print(tmp) 
                max_ = max(max_, int(tmp))
                min_ = min(min_, int(tmp))
        
        # print(max_, min_)
        return max_ - min_