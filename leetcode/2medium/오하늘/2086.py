<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution:
=======
class Leetcode.이재훈.Solution:
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    def minimumBuckets(self, hamsters: str) -> int:
        n = len(hamsters)
        hamsters = list(hamsters)
        count = 0  # 음식
        
        for i in range(n):
            if hamsters[i] == 'H':
                # 현재 햄스터를 먹일 방법 찾기
                if i > 0 and hamsters[i - 1] == 'B': #이미 왼쪽에 음식 있음
                    continue
                elif i < n - 1 and hamsters[i + 1] == '.':#오른쪽이 비어있다면 음식 배치
                    hamsters[i + 1] = 'B'
                    count += 1
                elif i > 0 and hamsters[i - 1] == '.': #왼쪽이 비어있으면 먹이 배치
                    hamsters[i - 1] = 'B'
                    count += 1
                else:
                    return -1
        
        return count
