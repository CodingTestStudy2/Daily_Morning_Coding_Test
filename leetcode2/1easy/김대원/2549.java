class Solution {
    public int distinctIntegers(int n) {
        if (n == 1) return 1;
        Set<Integer> set = new HashSet<>();
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i % j == 1) set.add(j);
            }
        }

        return set.size();
    }
}