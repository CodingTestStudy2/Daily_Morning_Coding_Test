class Solution:
    def check_valid(self, num: str) -> bool:
        n = len(num)

        if n == 1:
            return True

        for i in range(n//2):
            if num[i] == num[n-1-i]:
                return True

        return False

    def maxPalindromesAfterOperations(self, words: List[str]) -> int:
        # swap 후 앞뒤로 읽어도 똑같은 문자
        result = 0
        n = len(words)
        cnt_arr = set()

        for i in range(n):
            for j in range(i+1, n):
                # words[i][x] <-> words[j][y]            
                # 글자 스왑
                for x in range(len(words[i])):
                    for y in range(len(words[j])):
                        if words[i][x] == words[j][y]:
                            continue

                        w1 = list(words[i])
                        w2 = list(words[j])
                        w1[x], w2[y] = w2[y], w1[x]
                        # print(i, j, x, y, '-', w1, w2)
                        s1, s2 = ''.join(w1), ''.join(w2)

                        if self.check_valid(s1):
                            cnt_arr.add(s1)
                        if self.check_valid(s2):
                            cnt_arr.add(s2)
        
        print(cnt_arr)


