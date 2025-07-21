class Solution:
    def lastNonEmptyString(self, s: str) -> str:
        # 아 첨 등장하는 알파벳 지우기
        # 마지막 operation 전 결과 출력
        arr = []
        last_l = ''

        for l in s:
            arr.append(l)
            print(arr)

        for l in arr:
            if l == last_l:
                pass
            else:
                pass
