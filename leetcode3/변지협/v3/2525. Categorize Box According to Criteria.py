
'''
1. 아이디어 :
문제에 나온 조건에 맞게 분류한다.

2. 시간복잡도 :
o(1)

3. 자료구조/알고리즘 :
'''

class Solution:
    def categorizeBox(self, length: int, width: int, height: int, mass: int) -> str:
        volume = length * width * height
        
        heavy = True if mass >= 100 else False
        bulky = False
        
        if length >= 10 ** 4 or width >= 10 ** 4 or height >= 10 ** 4 or volume >= 10 ** 9:
            bulky = True
        
        if heavy and bulky:
            return 'Both'
        elif not heavy and not bulky:
            return "Neither"
        elif bulky and not heavy:
            return "Bulky"
        else:
            return "Heavy"