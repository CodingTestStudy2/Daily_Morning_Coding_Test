import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            int e0 = edge[i][0];
            int e1 = edge[i][1];
            graph.get(e0).add(e1);
            graph.get(e1).add(e0);
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);
        distance[1] = 0; 

        q.offer(1);

        while (!q.isEmpty()) {
            int current = q.poll();
            for (int neighbor : graph.get(current)) {
                if (distance[neighbor] == -1) {
                    distance[neighbor] = distance[current] + 1;  
                    q.offer(neighbor); 
                }
            }
        }

        int maxDistance = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] > maxDistance) {
                maxDistance = distance[i];
            }
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == maxDistance) {
                count++;
            }
        }

        return count;
    }
}
