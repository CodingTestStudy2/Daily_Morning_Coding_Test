class Solution:
    def cellsInRange(self, s: str) -> list[str]:
        # cells = list(map(str, s.split(":")))
        startCol = s[0]
        endCol = s[3]
        startRow = int(s[1])
        endRow = int(s[4])

        result = list()

        for col in range(ord(startCol), ord(endCol) + 1):
            for row in range(startRow, endRow+1):
                data = chr(col) + str(row)
                result.append(data)
        
        return result


if __name__ == "__main__":
    sol = Solution()
    print(sol.cellsInRange("K1:L2"))
    print(sol.cellsInRange("A1:F1"))