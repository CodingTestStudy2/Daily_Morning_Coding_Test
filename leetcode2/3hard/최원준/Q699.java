package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q699 {
    class Solution {
        public List<Integer> fallingSquares(int[][] positions) {
            int n = positions.length;
            List<Integer> ans = new ArrayList<>();
            List<int[]> squares = new ArrayList<>();

            int curr = 0;
            for (int i=0; i<n; i++) {
                int[] pos = positions[i];
                int left = pos[0], right = pos[0] + pos[1]; //2, 5

                int maxHeightInStack = pos[1];

                for (int[] square : squares) {
                    int sleft = square[0], sright = square[1], height = square[2]; // 1,3, 2

                    if (right <= sleft || sright <= left) continue;
                    maxHeightInStack = Math.max(maxHeightInStack, height + pos[1]);
                }
                squares.add(new int[]{left, right, maxHeightInStack});
                curr = Math.max(curr, maxHeightInStack);
                ans.add(curr);
            }
            return ans;
        }
    }
}
