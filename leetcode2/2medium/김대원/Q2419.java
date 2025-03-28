// 1. 아이디어 : 비트 길이가 가장 긴 것은 큰 값. max 값의 연속된 배열 길이 반환
// 2. 시간복잡도 : O(N)
// 3. 자료구조/알고리즘 : 배열

class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int max = Arrays.stream(nums).max().getAsInt();
        int prev = nums[0];
        int answer = 0;
        int cnt = 0;
        if (prev == max) {
            cnt = 1;
            answer = 1;
        }

        for (int i = 1; i < n; i++) {
            if (nums[i] == max) {
                cnt++;
            } else if (nums[i] == max && prev == nums[i]) {
                cnt++;
            } else {
                cnt = 0;
            }

            prev = nums[i];
            answer = Math.max(cnt, answer);
        }

        return answer;
    }
}
