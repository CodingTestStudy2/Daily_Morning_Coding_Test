class Solution:
    def numOfUnplacedFruits(self, fruits: List[int], baskets: List[int]) -> int:
        n = len(baskets)
        used = [None] * n

        # 같거나 작으면 담기
        # 전부 담아야함
        result = 0
        for f in fruits:
            for i in range(n):
                if used[i] is None and baskets[i] >= f:
                    used[i] = True
                    # print(used)
                    break
            else:
                result+=1
        
        return result

        