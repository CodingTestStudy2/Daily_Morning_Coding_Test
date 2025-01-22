package Leetcode;

public class Q2380 {
    class Solution {
        int MOD = 1_000_000_007;
        int[] groups, profits;
        int minProfit;
        int n;
        int length;
        Map<String, Integer> dp = new HashMap<>();


        public int backtrack(int i, int people, int profit) {
            if (i == groups.length) {
                return profit>=minProfit? 1:0;
            }
            String key = i + " " + people + " " + profit;
            if (dp.containsKey(key)) return dp.get(key);

            dp.put(key,backtrack(i+1, people, profit) % MOD); //skip

            if (people + groups[i] <= n) {
                dp.put(key, dp.get(key) + backtrack(i+1, people + groups[i], profit + profits[i]) % MOD);
            }

            return dp.get(key);

        }
        public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
            groups = group;
            profits = profit;
            this.minProfit = minProfit;
            this.n = n ;
            return backtrack(0, 0, 0);
        }
    }
}
