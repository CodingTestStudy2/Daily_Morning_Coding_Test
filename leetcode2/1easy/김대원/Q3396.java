class Solution {
    public int minimumOperations(int[] nums) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) map.put(x, map.getOrDefault(x, 0) + 1);

        int n = nums.length;
        if (map.size() == n) return 0;

        int count = n / 3 + 1;
        int idx = 0;
        while (answer < count) {
            int size = 3;
            while (size != 0 && idx < n) {
                int key = nums[idx];
                map.put(key, map.get(key) - 1);
                if (map.get(key) == 0) map.remove(key);
                idx++;
                size--;
            }

            boolean flag = true;
            for (int key : map.keySet()) {
                if (map.get(key) >= 2) {
                    flag = false;
                    break;
                }
            }

            answer++;
            if (flag) break;
        }

        return answer;
    }
}