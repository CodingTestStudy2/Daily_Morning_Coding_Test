
// 3개 선택, 0 -> 1, 1 -> 0
// 배열의 모든 요소 1
// 3 <= nums.length <= 10^5

// 1 0 0 1 0 0
// 1 1 1 0 0 0
// 1 1 1 1 1 1

// 0 1 1 0 1 1
// 1 0 0 0 1 1

// i ~ i + 2

// 0 1 1 1 0 0
// 1 0 0 1 0 0
// 1 1 1 0 0 0

class Solution {
    public int minOperations(int[] nums) {
        int answer = 0;
        int[] cnt = new int[nums.length];
        for (int x : nums) {
            if (x == 0) cnt[0]++;
            else cnt[1]++;
        }

        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (cnt[0] == 0) break;

            if (nums[i] == 0) {
                answer++;
                nums[i] = 1;
                cnt[0]--;
                cnt[1]++;

                if (nums[i + 1] == 0) {
                    cnt[0]--;
                    cnt[1]++;
                    nums[i + 1] = 1;
                } else {
                    cnt[1]--;
                    cnt[0]++;
                    nums[i + 1] = 0;
                }

                if (nums[i + 2] == 0) {
                    cnt[0]--;
                    cnt[1]++;
                    nums[i + 2] = 1;
                } else {
                    cnt[1]--;
                    cnt[0]++;
                    nums[i + 2] = 0;
                }
            }
        }

        if (cnt[0] != 0) return -1;
        return answer;
    }
}

