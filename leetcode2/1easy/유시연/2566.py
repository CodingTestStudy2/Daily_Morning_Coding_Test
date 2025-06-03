class Leetcode.이재훈.Solution:
    def minMaxDifference(self, num: int) -> int:
        str_num = str(num)
        max_val = num
        min_val = num

        for d in set(str_num):
            if d != '9':
                max_candidate = int(''.join('9' if ch == d else ch for ch in str_num))
                max_val = max(max_val, max_candidate)

        for d in set(str_num):
            if d != '0':
                min_candidate = int(''.join('0' if ch == d else ch for ch in str_num))
                min_val = min(min_val, min_candidate)

        return max_val - min_val
