package 이재훈;

/*
1. 아이디어 :

2. 시간복잡도 :
O( n)
3. 자료구조/알고리즘 :
- /
 */

public class Q983 {
    class Solution {
        public int mincostTickets(int[] days, int[] costs) {
            // days 의 마지막 value가 마지막 날짜임
            // 각 날짜에만 방문예정..
            // 방문 날짜가 아닐경우 그냥 스킵

            int lastDay = days[days.length-1];

            Set<Integer> visitDays = new HashSet<>();
            for(int d : days) {
                visitDays.add(d);
            }
            // 마지막 날까지 구해야된다.
            int[] dp = new int[lastDay+1];

            for(int i = 1; i<=lastDay; i++) {
                if(visitDays.contains(i)) {
                    // 1day pass
                    int cost1 = dp[Math.max(0,i-1)] + costs[0];
                    // 7day pass
                    int cost7 = dp[Math.max(0,i-7)] + costs[1];
                    // 30 day pass
                    int cost30 = dp[Math.max(0,i-30)] + costs[2];
                    dp[i] = Math.min(cost1, Math.min(cost7, cost30));
                } else {
                    dp[i] = dp[i-1];
                }
            }

            return dp[lastDay];

        }
    }
}