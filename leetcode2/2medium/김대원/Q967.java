class Solution {

    static Set<Integer> set;

    public int[] numsSameConsecDiff(int n, int k) {
        set = new HashSet<>();
        int digit = (int) Math.pow(10, n - 1);
        backtrack(0, digit, n, k, 0, 0);
        int[] answer = new int[set.size()];
        int idx = 0;
        for (int x : set) answer[idx++] = x;
        Arrays.sort(answer);
        return answer;
    }

    private void backtrack(int depth, int digit, int n, int k, int num, int prev) {
        if (depth == n) {
            set.add(num);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (i == 0 && depth == 0) continue;
            if (depth == 0) {
                backtrack(depth + 1, digit / 10, n, k, i * digit, i);
            } else {
                int gap = Math.abs(i - prev);
                if (gap >= 0 && gap < 10 && gap == k)  {
                    backtrack(depth + 1, digit / 10, n, k, num + i * digit, i);
                }
            }
        }
    }
}