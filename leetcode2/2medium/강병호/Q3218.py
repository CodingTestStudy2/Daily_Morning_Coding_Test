class Leetcode.이재훈.Solution:
    def minimumCost(self, m: int, n: int, horizontalCut: list[int], verticalCut: list[int]) -> int:
        horizontalCutCount = 0
        verticalCutCount = 0

        horizontalCut.sort(reverse=True)
        verticalCut.sort(reverse=True)
        horizontalIndex, verticalIndex, result = 0, 0, 0
        # print(f"horizontalCut : {horizontalCut}")
        # print(f"verticalCut : {verticalCut}")
        while horizontalCutCount + verticalCutCount != len(horizontalCut) + len(verticalCut):
            if verticalIndex == n-1 :
                # print(horizontalCut[horizontalIndex] * (verticalCutCount + 1))
                result += horizontalCut[horizontalIndex] * (verticalCutCount + 1)
                horizontalCutCount += 1
                horizontalIndex += 1
                continue
            elif horizontalIndex == m-1 :
                # print(verticalCut[verticalIndex] * (horizontalCutCount + 1))
                result += verticalCut[verticalIndex] * (horizontalCutCount + 1)
                verticalCutCount += 1
                verticalIndex += 1
                continue
            
            if horizontalCut[horizontalIndex] > verticalCut[verticalIndex]:
                # print(horizontalCut[horizontalIndex] * (verticalCutCount + 1))
                result += horizontalCut[horizontalIndex] * (verticalCutCount + 1)
                horizontalCutCount += 1
                horizontalIndex += 1
            elif verticalCut[verticalIndex] >= horizontalCut[horizontalIndex]:
                # print(verticalCut[verticalIndex] * (horizontalCutCount + 1))
                result += verticalCut[verticalIndex] * (horizontalCutCount + 1)
                verticalCutCount += 1
                verticalIndex += 1
            
        return result

if __name__ == "__main__":
    sol = Leetcode.이재훈.Solution()

    # print(sol.minimumCost(3, 2, [1,3], [5]))
    # print(sol.minimumCost(2, 2, [7], [4]))
    print(sol.minimumCost(6, 3, [2,3,2,3,1], [1,2]))