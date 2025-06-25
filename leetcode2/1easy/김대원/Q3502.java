class Solution {
    public int[] minCosts(int[] cost) {
        int n = cost.length;
        int[] answer = new int[n];
        answer[0] = cost[0];
        int min = answer[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, cost[i]);
            answer[i] = min;
        }

        return answer;
    }
}
