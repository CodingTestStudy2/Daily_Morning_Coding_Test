class Solution {

    static List<Set<Integer>> graph;

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> answer = new ArrayList<>();
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int v1 = edge[0], v2 = edge[1];
            graph.get(v2).add(v1);
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> set = graph.get(i);
            Set<Integer> tmp = new HashSet<>(set);
            int[] ch = new int[n];
            for (int p : set) {
                dfs(p, tmp, ch);
            }

            List<Integer> list = new ArrayList<>(tmp);
            Collections.sort(list);
            answer.add(list);
        }

        return answer;
    }

    private void dfs(int v, Set<Integer> tmp, int[] ch) {
        ch[v] = 1;
        tmp.addAll(graph.get(v));
        for (int next : graph.get(v)) {
            if (ch[next] == 0) {
                dfs(next, tmp, ch);
            }
        }
    }
}

// 1 <= n <= 1000
// 0 <= edges.length <= 2000