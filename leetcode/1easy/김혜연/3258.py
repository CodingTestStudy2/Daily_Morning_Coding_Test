class Leetcode.이재훈.이재훈.Solution:
    def countKConstraintSubstrings(self, s: str, k: int) -> int:
        count = [0, 0]  # count[0]은 '0'의 개수, count[1]은 '1'의 개수를 저장
        result = 0
        left = 0

        for right in range(len(s)):
            count[int(s[right])] += 1

            # '0'과 '1'의 개수가 모두 k를 초과하면 왼쪽 포인터를 이동
            while count[0] > k and count[1] > k:
                count[int(s[left])] -= 1
                left += 1

            # 현재 윈도우 내의 모든 부분 문자열은 조건을 만족
            result += right - left + 1

        return result
