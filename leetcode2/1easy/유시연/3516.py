class Solution:
    def findClosest(self, x: int, y: int, z: int) -> int:
        while True:
            if x == z and y == z:
                return 0

            if x == z: 
                return 1
    
            if y == z: 
                return 2


            if x < z:
                x += 1
            elif x > z:
                x -= 1

            if y < z:
                y += 1
            elif y > z:
                y -= 1
   