package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q3017 {
    class Solution {
        public long[] removeZeroIdx(long[] arr) {
            long[] ans = new long[arr.length];
            for (int i=1; i<arr.length; i++) ans[i-1] = arr[i];
            return ans;
        }

        public long[] countOfPairs(int n, int x, int y) {
            long[] ans = new long[n];
            if (x == y) {
                for (int distance = 1; distance<n; distance++) {
                    ans[distance] = (n-distance)*2;
                }
                return removeZeroIdx(ans);
            }

            if (x>y) {
                int temp = x; x = y; y = temp;
            }

            // 1 to midPoint (before x + midPoint)
            int midPoint = (x + y)/2;
            for (int distance = 1; distance<midPoint; distance++) {
                ans[distance] = (midPoint-distance)*2;
            }

            // after y
            int offset = x;
            int afterY = n - y;
            for (int distance = 1; distance<afterY; distance++) {
                ans[distance + offset] = (afterY - distance) * 2;
            }

            // between x and y



            return ans;
        }
    }
}
