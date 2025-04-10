// 1. 아이디어 : root부터 방문할 수 있는 노드 개수 카운트
// 2. 시간복잡도 : O(N + M)
// 3. 자료구조/알고리즘 : List, Set

class Solution {

    static int answer;
    static Set<Integer> set;
    static List<List<Integer>> list;

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        set = new HashSet<>();
        for (int x : restricted) set.add(x);

        list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(new ArrayList<>());
        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        answer = 0;
        search(0);
        return answer;
    }

    private void search(int vertex) {
        if (set.contains(vertex)) return;
        set.add(vertex);
        answer++;

        for (int next : list.get(vertex)) {
            search(next);
        }
    }
}
