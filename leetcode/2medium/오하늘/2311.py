# 예제 1 틀림..
class Leetcode.이재훈.Solution:
    def longestSubsequence(self, s: str, k: int) -> int:
        parts = s.split("1") # 1 단위로 삭제

        zero_cnt = sum(len(part) for part in parts)  # 0의 개수
        ones_cnt = len(parts)-1  # '1'의 개수

        #뒤에서부터 1을 하나씩 추가하며 확인
        binary_value = 0
        added_ones = 0
        power = 1
        for i in range(ones_cnt):
            binary_value += power  # 현재 자리수의 1 추가
            if binary_value > k:
                break  # k를 초과하면 멈춤
            added_ones += 1
            power *= 2  # 다음 자리수를 위해 2배 증가
        
        return zero_cnt + added_ones
