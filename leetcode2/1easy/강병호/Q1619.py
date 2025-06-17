class Solution:
    def trimMean(self, arr: List[int]) -> float:
        arr.sort()

        n = len(arr)
        trimNumCnt = int(n * 0.05)

        trimedArr = arr[trimNumCnt:n-trimNumCnt]
        print(trimedArr)

        trimedMean = sum(trimedArr) / (n- 2*trimNumCnt)

        print(trimedMean)

        return round(trimedMean, 5)

