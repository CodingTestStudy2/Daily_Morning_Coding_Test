import java.util.*;

// 못품
class Solution {
    public int[] solution(int[][] dice) {
        int n = dice.length;
        
        boolean[] isVisited = new boolean[n + 1];
        List<int[]> dices = new ArrayList<>();
        
        dfs(0, new int[n / 2], n, isVisited, dices);
        
        for (var e : dices) {
            for (int i = 0; i < e.length; ++i) {
                System.out.printf(e[i] + " ");
            }
            // 내가 고른 주사위의 순열
            // 상대방이 고른 주사위의 순열
        }
        
        int[] ans = {};
        return ans;
     }
    
     void dfs(int depth, int[] cur, int n, boolean[] isVisited, List<int[]> dices) {
        if (depth == n / 2) {
            dices.add(cur.clone());
            return;
        }
        
        for (int i = 1; i <= n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                cur[depth] = i;
                dfs(depth + 1, cur, n, isVisited, dices);
                isVisited[i] = false;
            }
        }
    }
}
