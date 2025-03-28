class Solution:
    def numOfUnplacedFruits(self, fruits: List[int], baskets: List[int]) -> int:
        count = len(fruits)
        
        for i in range(len(fruits)):
            for j in range(len(baskets)):
                if fruits[i] <= baskets[j]:
                    count -= 1
                    del baskets[j]
                    break
                else:
                    continue
                    
        return count
