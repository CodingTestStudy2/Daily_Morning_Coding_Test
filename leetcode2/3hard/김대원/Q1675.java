
// any number of times
// ele % 2 == 0 -> ele / 2
// ele % 2 == 1 -> ele * 2
// return:  minimum deviation of two elements

// nums: 4, 1, 5, 20, 3
// -> 4 2(1) 5 5(2) 3

// 1 2 3 4  -> 1 2 3 2 -> 2 2 3 2 (3 - 2)
// 4 1 5 20 3 -> 4 2 5 20 3 -> 4 2 5 10 3 -> 4 2 5 5 3 (5 - 2)

// 2 <= nums.length <= 5 * 10^4

// 20, 1: 19
// 10, 1: 9
// 5, 1: 4
// 5, 2: 3

// 2 8 6 1 6 -> 2 4 6 1 6 -> 2 4 3 1 6 -> 2 4 3 1 3 -> 2 2 3 1 3
// 8 1
// 6 1
// 6 1
// 4 1
// 3 1

class Solution {
    public int minimumDeviation(int[] nums) {
        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!map.containsKey(num)) {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(i);
                map.put(num, set);
            } else {
                map.get(num).add(i);
            }
        }

        int result = Integer.MAX_VALUE;
        while (true) {
            int mx = getMax(nums);
            int mn = getMin(nums);

            if (mx - mn < result) {
                result = Math.min(result, mx - mn);

                if (mx % 2 == 0) {
                    TreeSet<Integer> set = map.get(mx);
                    int idx = set.pollFirst();
                    if (set.isEmpty()) map.remove(mx);

                    mx /= 2;
                    nums[idx] = mx;
                    if (!map.containsKey(mx)) {
                        TreeSet<Integer> tSet = new TreeSet<>();
                        set.add(idx);
                        map.put(mx, set);
                    } else {
                        map.get(mx).add(idx);
                    }
                } else if (mn % 2 == 1) {
                    TreeSet<Integer> set = map.get(mn);
                    int idx = set.pollFirst();
                    if (set.isEmpty()) map.remove(mn);

                    mn *= 2;
                    nums[idx] = mn;
                    if (!map.containsKey(mn)) {
                        TreeSet<Integer> tSet = new TreeSet<>();
                        set.add(idx);
                        map.put(mn, set);
                    } else {
                        map.get(mn).add(idx);
                    }
                }
            } else {
                break;
            }
        }

        return result;
    }

    private int getMax(int[] nums) {
        return Arrays.stream(nums).max().getAsInt();
    }

    private int getMin(int[] nums) {
        return Arrays.stream(nums).min().getAsInt();
    }
}
