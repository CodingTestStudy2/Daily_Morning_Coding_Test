class Solution:
    def numOfSubarrays(self, arr: List[int]) -> int:
        n = len(arr)
        sumarr = []

        c = 0
        for i in range(n):
            c += arr[i]
            sumarr.append(c)

        
        k = 1
        kk = 0
        result = 0
        for i in range(n):
            if sumarr[i] % 2 == 0:
                result += kk
                result %= (10 ** 9 + 7)

                k += 1
            else:
                result += k
                result %= (10 ** 9 + 7)
                kk += 1
            
        return result % (10 ** 9 + 7)