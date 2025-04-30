// 1. 아이디어 :
// 2. 시간복잡도 :
// 3. 자료구조/알고리즘 :

class Solution {

    static List<List<Integer>> graph;
    static Set<Integer> set;

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer> answer = new ArrayList<>();
        set = new HashSet<>();

        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < invocations.length; i++) {
            int[] info = invocations[i];
            int from = info[0];
            int to = info[1];

            graph.get(from).add(to);
        }

        int[] ch = new int[n];
        ch[k] = 1;
        findKLoad(k, ch, k);

        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (ch[i] == 1) continue;
            if (!flag) break;

            for (int next : graph.get(i)) {
                if (set.contains(next)) {
                    set.clear();
                    flag = false;
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!set.contains(i)) {
                answer.add(i);
            }
        }

        return answer;
    }

    private void findKLoad(int node, int[] ch, int k) {
        set.add(node);
        for (int next : graph.get(node)) {
            if (ch[next] == 0) {
                ch[next] = 1;
                findKLoad(next, ch, k);
            }
        }
    }
}