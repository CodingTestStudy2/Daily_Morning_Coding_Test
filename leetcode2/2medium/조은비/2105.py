class Solution:
    def minimumRefill(self, plants: List[int], capacityA: int, capacityB: int) -> int:
        # a 오 -> 왼 / b 왼 -> 오 동시 물뿌리기 진행
        # start 지점
        i = 0
        k = len(plants) -1

        a, b = capacityA, capacityB
        refill = 0

        # 마주치기 직전까지
        while i < k:
            # 물채우기
            if a < plants[i]:
                refill += 1
                a = capacityA
            a -= plants[i]

            if b < plants[k]:
                refill += 1
                b = capacityB
            b -= plants[k]

            # print(i, k, a, b)
            i += 1
            k -= 1
        
        if i == k:
            if max(a, b) < plants[i]:
                refill += 1
            # print(i, k, a, b)

        return refill