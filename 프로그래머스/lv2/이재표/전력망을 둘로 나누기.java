import java.util.*;

class Solution {
    private List<List<Integer>> tree;
    public int solution(int n, int[][] wires) {
        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] wire : wires) {
            int e1 = wire[0];
            int e2 = wire[1];
            tree.get(e1).add(e2);
            tree.get(e2).add(e1);
        }
        int minD = Integer.MAX_VALUE;
        for (int[] wire : wires) {
            int e1 = wire[0];
            int e2 = wire[1];
            boolean[] visited = new boolean[n + 1];
            visited[e2] = true;
            int count1 = dfs(e1, visited);
            visited = new boolean[n + 1];
            visited[e1] = true;
            int count2 = dfs(e2, visited); 
            minD = Math.min(minD, Math.abs(count1 - count2));
        }
        return minD;
    }
    private int dfs(int node, boolean[] visited) {
        visited[node] = true;
        int count = 1;
        for (int neighbor : tree.get(node)) {
            if (!visited[neighbor]) {
                count += dfs(neighbor, visited);
            }
        }
        return count;
    }
}
