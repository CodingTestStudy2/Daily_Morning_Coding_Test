# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;

<<<<<<< HEAD
public class Leetcode.이재훈.이재훈.Solution {
=======
public class Leetcode.이재훈.Solution {
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = 0, maxCop = 0;
        for (int[] problem : problems) {
            maxAlp = Math.max(maxAlp, problem[0]);
            maxCop = Math.max(maxCop, problem[1]);
        }

        int[][] dp = new int[maxAlp + 1][maxCop + 1];
        for (int i = 0; i <= maxAlp; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        alp = Math.min(alp, maxAlp);
        cop = Math.min(cop, maxCop);
        dp[alp][cop] = 0;

        for (int alpScore = alp; alpScore <= maxAlp; alpScore++) {
            for (int copScore = cop; copScore <= maxCop; copScore++) {
                int currTime = dp[alpScore][copScore];
                if (currTime == Integer.MAX_VALUE) continue; // 유효하지 않은 점수는 스킵

                // +1 alp
                if (alpScore + 1 <= maxAlp) {
                    dp[alpScore + 1][copScore] = Math.min(dp[alpScore + 1][copScore], currTime + 1);
                }

                // +1 cop
                if (copScore + 1 <= maxCop) {
                    dp[alpScore][copScore + 1] = Math.min(dp[alpScore][copScore + 1], currTime + 1);
                }

                for (int[] problem : problems) {
                    int reqAlp = problem[0];
                    int reqCop = problem[1];
                    int gainAlp = problem[2];
                    int gainCop = problem[3];
                    int cost = problem[4];

                    if (alpScore >= reqAlp && copScore >= reqCop) {
                        int nextAlp = Math.min(maxAlp, alpScore + gainAlp);
                        int nextCop = Math.min(maxCop, copScore + gainCop);
                        dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], currTime + cost);
                    }
                }
            }
        }

        return dp[maxAlp][maxCop];
    }
}
'''



