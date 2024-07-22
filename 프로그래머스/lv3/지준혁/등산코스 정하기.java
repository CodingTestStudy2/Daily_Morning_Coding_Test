// 해결 X
class Solution {
    
    List<int[]>[] adj = new ArrayList[50004];
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        
        for (int i = 0; i <= n; ++i) adj[i] = new ArrayList<>();
        
        for (int i = 0; i < paths.length; ++i) {
            adj[paths[i][0]].add(new int[]{paths[i][2], paths[i][1]});
            adj[paths[i][1]].add(new int[]{paths[i][2], paths[i][0]});
        }
        
        int[] answer = {};
        return answer;
    }
    int [] dijsktra(int st, int n, int[] gates, int[] summits) {
        int[] d = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        d[st] = 0;
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curWeight = cur[0];
            int curNode = cur[1];
            
            if (d[curNode] != curWeight) continue;
            
            for (var nxt : adj[curNode]) {
                int nxtWeight = nxt[0];
                int nxtNode = nxt[1];
                int intensity = Math.max(d[curNode], nxt)
            }
        }
    }
}
