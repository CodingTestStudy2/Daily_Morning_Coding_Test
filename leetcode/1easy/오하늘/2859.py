<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution:
=======
class Leetcode.이재훈.Solution:
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    def sumIndicesWithKSetBits(self, nums: List[int], k: int) -> int:
        ans = 0
        def dfs(n, result):
            if n == 0:
                return
            dfs(n // 2, result)
            result.append(str(n % 2))  # 리스트에 추가

        for i, n in enumerate(nums): # 배열이 아니라 인덱스를 이진법으로 구해야 함.
            res = []
            dfs(i, res)
            result = ''.join(res)
            print(result)
            
            if result.count('1') == k:
                ans+=n
        return ans
