class Solution:
    def maxOperations(self, nums: List[int]) -> int:
        score = nums.pop(0) + nums.pop(0)
        cnt = 1

        # 두개의 num 더해 score, 삭제
        # nums에 1개이하까지 삭제 / 같은 스코어 기록
        while len(nums) >= 2:
            a = nums.pop(0)
            b = nums.pop(0)
            if a+b == score:
                cnt += 1
                print('=', score, cnt)
            else:
                # e cannot perform the next operation 
                break
        return cnt