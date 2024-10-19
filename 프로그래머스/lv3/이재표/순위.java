import java.util.*;

class Solution {
    boolean[][] visit;
    List<List<Integer>> graph;
    int[][] game;
    public int solution(int n, int[][] results) {
        int answer = 0;
        visit = new boolean[n+1][n+1];
        game = new int[n+1][n+1];
        graph = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < results.length; i++) {
            graph.get(results[i][0]).add(results[i][1]);
        }

        for (int i = 1; i <= n; i++) {
            dfs(i, i);
        }

        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (game[i][j] == 1 || game[i][j] == -1) {
                    cnt++;
                }
            }
            if (cnt == n - 1) {
                answer++;
            }
        }

        return answer;
    }

    public void dfs(int init, int current) {
        List<Integer> next = graph.get(current);
        for (int i = 0; i < next.size(); i++) {
            if (game[init][next.get(i)] == 0) {
                game[init][next.get(i)] = 1;  
                game[next.get(i)][init] = -1; 
                dfs(init, next.get(i));       
            }
        }
    }
}
