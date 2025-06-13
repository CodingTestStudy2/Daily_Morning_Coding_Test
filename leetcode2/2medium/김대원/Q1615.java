class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        List<List<String>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] road : roads) {
            int v1 = road[0];
            int v2 = road[1];
            String ll = v1 + " " + v2;
            graph.get(v1).add(ll);
            graph.get(v2).add(ll);
        }

        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            int s1 = graph.get(i).size();
            for (int j = i + 1; j < n; j++) {
                int s2 = graph.get(j).size();
                if (max < s1 + s2) {
                    max = s1 + s2;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n - 1; i++) {
            int s1 = graph.get(i).size();
            for (int j = i + 1; j < n; j++) {
                int s2 = graph.get(j).size();
                if (s1 + s2 == max) {
                    Set<String> set = new HashSet<>(graph.get(i));
                    set.addAll(new HashSet<>(graph.get(j)));
                    answer = Math.max(answer, set.size());
                }
            }
        }

        return answer;
    }
}