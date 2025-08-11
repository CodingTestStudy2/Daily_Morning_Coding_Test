class Solution:
    def soupServings(self, n: int) -> float:
        # 문제가 잘 이해가 안감 ,,,
        # A 가 B보다 먼저 빌 확률 혹은 모든 수프가 동시에 빌 확률

        def prob(a, b):
            
            if a <= 0 and b <= 0:
                return 0.5
            if a <= 0:
                return 1.0
            if b <= 0:
                return 0.0
            
            probability = 0.25 * (
                prob(a-100, b) +
                prob(a-75, b-25) +
                prob(a-50, b-50) +
                prob(a-25, b-75)
            )

            return probability

        return prob(n, n)