class Solution:
    def minPartitions(self, n: str) -> int:

        max_num = -1

        for num in n:
            int_num = int(num)
            if max_num < int_num:
                max_num = int_num

        return max_num