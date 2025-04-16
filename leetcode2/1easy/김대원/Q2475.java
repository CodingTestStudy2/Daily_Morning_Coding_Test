class Solution {
    public int unequalTriplets(int[] nums) {
        int n = nums.length;
        int answer = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]) answer++;
                }
            }
        }

        return answer;
    }
}

// 서로 다른 값을 갖는 인덱스 쌍