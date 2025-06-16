class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if (n % k != 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        Arrays.sort(nums);
        int idx = 0;
        for (int i = 0; i < n / k; i++) {
            int num = nums[idx++];
            if (map.get(num) == 0) {
                i--;
                continue;
            }

            for (int j = num; j < num + k; j++) {
                if (!map.containsKey(j) || map.get(j) == 0) return false;
                map.put(j, map.get(j) - 1);
            }
        }

        return true;
    }
}