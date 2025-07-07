class Solution:
    def twoEggDrop(self, n: int) -> int:
        # m회 drop으로 찾음
        # m(m+1)/2 < n ... 그럼 m(m+1)/2 >= n 이 되는 m을 찾으면
        m = 1
        while m * (m+1) // 2 < n:
            m+=1
            # print(m)
        return m