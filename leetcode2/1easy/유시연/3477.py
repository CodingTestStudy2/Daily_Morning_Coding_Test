<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution:
=======
class Leetcode.이재훈.Solution:
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
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
