import heapq

class Solution:
    def sumOfLargestPrimes(self, s: str) -> int:
        checklist = set()
        checklist.add(1)
        n = len(s)
        heap = []
        heapq.heapify(heap)
        count= 0
        m = n-1
        for i in range(m, -1, -1):
            for j in range(n-i):
                check = int(s[j:j+i+1])
                if not check in checklist:
                    checklist.add(check)
                    bo = False
                    for k in range(2, int(check**0.5 + 1)):
                        if check % k == 0:
                            bo = True
                            break
                    
                    if not bo:
                        if count == 3:
                            c = heapq.heappop(heap)
                            if c < check:
                                heapq.heappush(heap, check)
                            else:
                                heapq.heappush(heap, c)
                        else:
                            count += 1
                            heapq.heappush(heap, check)
            


        if count == 0:
            return 0
        else:
            result = 0
            while(heap):
                result += heapq.heappop(heap)
            
        
            return result