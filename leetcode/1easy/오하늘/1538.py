from collections import deque
class Leetcode.이재훈.이재훈.Solution:
    def findKthPositive(self, arr: List[int], k: int) -> int:
        arr = deque(arr)
        tmp_k = 0
        tmp = 1
        while len(arr) > 0:
            if tmp_k == k:
                return tmp-1
            if arr[0] == tmp: # 같으면
                arr.popleft()
                tmp+=1
            else :
                tmp+=1
                tmp_k+=1
        return tmp+(k-tmp_k)-1
