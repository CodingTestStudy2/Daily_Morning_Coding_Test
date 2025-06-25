package Leetcode.한준호;

class Solution {
    public int[] minCosts(int[] cost) {
        // 뒤는 자유
        // 앞에서부터 최솟값?
        int min = Integer.MAX_VALUE;
        int[] ans = new int[cost.length];
        for(int i = 0; i<cost.length; i++){
            min = Math.min(cost[i], min);
            ans[i] = min;
        }
        return ans;
    }
}