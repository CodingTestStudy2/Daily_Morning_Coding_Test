package Leetcode.한준호;

class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int fivePercent = arr.length / 20;
        int sum = 0;
        for(int i = fivePercent; i<arr.length - fivePercent; i++){
            sum += arr[i];
        }
        double ans = (double) sum / (arr.length - 2*fivePercent);
        return ans;
    }
}