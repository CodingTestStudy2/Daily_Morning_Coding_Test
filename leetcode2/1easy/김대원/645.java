class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        boolean[] ch = new boolean[n + 1];
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            ch[x] = true;
            if (!set.add(x)) result.add(x);
        }

        for (int i = 1; i <= n; i++) {
            if (!ch[i]) result.add(i);
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) answer[i] = result.get(i);
        return answer;
    }
}
