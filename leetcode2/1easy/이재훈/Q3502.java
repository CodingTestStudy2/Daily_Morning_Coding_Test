package Leetcode.이재훈;

/*
1. 아이디어 :

- res[i]는 cost[0]부터 cost[i]까지 중 가장 작은 값

2. 시간복잡도 :
O( n )
3. 자료구조/알고리즘 :
- /
 */

public class Q3502 {

    class Solution {
        public int[] minCosts(int[] cost) {

            int n = cost.length;
            int[] res = new int[n];
            res[0] = cost[0];

            for(int i = 1; i<n; i++) {
                res[i] = Math.min(res[i-1],cost[i]);
            }
            return res;
        }
    }
}