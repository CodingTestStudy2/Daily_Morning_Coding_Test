class Solution:
    def ambiguousCoordinates(self, s: str) -> List[str]:
        
        s = s[1:-1]
        n = len(s)
        output = []

        # 왼 오 분배 필요
        for i in range(1, n):
            left = s[:i]
            right = s[i:]

            l = left
            r = right

            # 왼쪽
            if left == "0":
                l = left

            else: # . 붙이기
                j = len(left)
                for k in range(j, 1):
                    l = left[:j] + "." + left[j:]

            # 오른쪽
            if right == "0":
                r = right
            
            else:
                j = len(right)
                for k in range(j, 1):
                    r = right[:j] + "." + right[J:]

        # 결과(공통)
        result = f"({l}, {r})"
        output.append(result)

        return output
        
    # 0이 있음 ...

    # 00011
    # 0/0011 - 0/001.1
    # 00/011 - 0.0 X
    # 000/11 - 0.00 X
    # 0001/1 - 0.001, 00.X

# 백트랙킹