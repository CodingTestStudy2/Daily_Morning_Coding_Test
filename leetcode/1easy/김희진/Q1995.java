public class Q1995 {

    public int countQuadruplets(int[] nums) {
        int res = 0;
        int len = nums.length;

        Map<Integer, Integer> count = new HashMap<>();
        count.put(nums[len-1] - nums[len-2], 1);

        for (int b = len - 3; b >= 1; b--) {
            for (int a = b - 1; a >= 0; a--) {
                res += count.getOrDefault(nums[a] + nums[b], 0);
            }

            for (int d = len - 1; d > b; d--) {
                count.put(nums[d] - nums[b], count.getOrDefault(nums[d] - nums[b], 0) + 1);
            }
        }

        return res;
    }

}
