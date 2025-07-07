class Solution:
    def maximumJumps(self, nums: List[int], target: int) -> int:
        n = len(nums)

        # 0 ~ n회 점프 가능, 이동경로 인덱스: jump
        jump = [None] * n
        jump[0] = 0

        que = deque([0])
        # 최대 점프 간선찾기...
        while que:
            # 0번 인덱스부터 시작
            i = que.popleft()

            # 점프가능한 인덱스 j
            for j in range(i+1, n):
                if -target <= nums[j] - nums[i] <= target:
                    if jump[j] is None or jump[j] < jump[i] + 1:
                        jump[j] = jump[i]
                        print(jump[j])
        return i