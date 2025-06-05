# 문제 이해 및 슬라이딩 윈도우 참고 했는데도,, 안풀림

<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution:
=======
class Leetcode.이재훈.Solution:
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    def countKConstraintSubstrings(self, s: str, k: int) -> int:
        def count_with_limit(char: str) -> int:
            left = 0
            count = 0
            char_count = 0

            for right in range(len(s)):
                if s[right] == char:
                    char_count += 1

                while char_count > k:
                    if s[left] == char:
                        char_count -= 1
                    left += 1

                count += (right - left + 1)

            return count

        return count_with_limit('0') + count_with_limit('1')
