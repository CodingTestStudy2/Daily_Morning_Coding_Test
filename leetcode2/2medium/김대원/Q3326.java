class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int answer = 0;
        for (int i = n - 2; i >= 0; i--) {
            while (nums[i] > nums[i + 1]) {
                int divide = 1;
                if (!map.containsKey(nums[i])) {
                    divide = getG(nums[i]);
                    map.put(nums[i], divide);
                } else {
                    divide = map.get(nums[i]);
                }

                if (divide == 1) return -1;
                else {
                    nums[i] /= divide;
                    answer++;
                }
            }
        }

        return answer;
    }

    private int getG(int num) {
        for (int i = num / 2; i >= 1; i--) {
            if (num % i == 0) return i;
        }

        return 1;
    }
}
