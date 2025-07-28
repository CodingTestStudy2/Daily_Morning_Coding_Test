class Solution:
    def asteroidsDestroyed(self, mass: int, asteroids: List[int]) -> bool:
        # 질량이 크거나 같으면 파괴 - 전부 파괴되면 true
        # 가장 큰 질량?
        result = False
        
        # asteroids 정렬
        asteroids.sort()
        # max_a = asteroids[-1]

        # sum_a = sum(asteroids)
        sum_a = mass
        for a in asteroids:
            if a <= sum_a:
                sum_a += a
                result = True
            else:
                return False
                
            # print(sum_a, max_a)

        return result