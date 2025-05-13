class Solution:
    def numOfUnplacedFruits(self, fruits: list[int], baskets: list[int]) -> int:
        length = len(fruits)
        placed = [False] * length
        result, j = 0, 0

        while j != length:
            for i in range(0, length):
                if placed[i]:
                    continue

                if fruits[j] > baskets[i] and i == length-1: # unplace
                    break
                elif fruits[j] <= baskets[i]:
                    placed[i] = True
                    break
            
            j+=1

        for p in placed:
            if not p:
                result += 1

        return result


if __name__ == "__main__":
    sol = Solution()

    # print(sol.numOfUnplacedFruits([4, 2, 5], [3, 5, 4]))
    print(sol.numOfUnplacedFruits([8, 5], [1, 8]))