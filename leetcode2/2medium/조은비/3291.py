
class Solution:
    def minValidStrings(self, words: List[str], target: str) -> int:
        # words -> target 만들 수 있는 최소
        n = len(target)
        st = [None] * (n+1)
        st[0] = 0

        for i in range(n):
            # None까지 갓음 일단 건너뛰기
            if st[i] is None:
                continue

            for word in words:
                for k in range(1, len(word)+1):
                    if i+k > n:
                        break

                    t_sub = target[i:i+k]
                    w_sub = word[:k]

                    if t_sub == w_sub:
                        # print(t_sub, w_sub, '-', i, word, st)
                        cnt = st[i]
                        if st[i+k] is None or cnt + 1 < st[i+k]:
                            st[i+k] = cnt + 1
                    else:
                        break