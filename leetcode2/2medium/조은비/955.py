class Solution:
    def minDeletionSize(self, strs: List[str]) -> int:
        n = len(strs)
        m = len(strs[0])
        cnt = 0

        # strs[i] 하나씩 지우면서 정렬 확인?
        for j in range(m):
            for i in range(n-1):
                print(strs[i], strs[i][j], strs[i+1][j])
                
                # 정렬이 어긋나면 다음 문자열로 ㄱㄱ
                if strs[i][j] > strs[i+1][j]:
                    cnt += 1
                    break
                
            return cnt

                