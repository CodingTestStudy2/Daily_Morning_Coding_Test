class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= c; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < connections.length; i++) {
            int[] connection = connections[i];
            int v1 = connection[0], v2 = connection[1];
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        int[] group = new int[c + 1];
        int gNum = 0;
        for (int i = 1; i <= c; i++) {
            if (group[i] == 0) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                gNum++;
                group[i] = gNum;

                while (!queue.isEmpty()) {
                    int now = queue.poll();
                    for (int next : graph.get(now)) {
                        if (group[next] == 0) {
                            group[next] = gNum;
                            queue.offer(next);
                        }
                    }
                }
            }
        }

        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            gNum = group[i];
            map.computeIfAbsent(gNum, k -> new TreeSet<>()).add(i);
        }

        List<Integer> result = new ArrayList<>();
        int[] ch = new int[c + 1];
        for (int i = 0; i < queries.length; i++) {
            int[] querie = queries[i];
            int command = querie[0], station = querie[1];

            gNum = group[station];
            TreeSet<Integer> set = map.get(gNum);
            if (command == 1) {
                if (ch[station] == 0) result.add(station);
                else {
                    if (!set.isEmpty()) result.add(set.first());
                    else result.add(-1);
                }
            } else {
                if (ch[station] == 0) ch[station] = 1;
                if (!set.isEmpty()) set.remove(station);
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}


// Input: c = 5, connections = [[1,2],[2,3],[3,4],[4,5]],
// queries = [[1,3],[2,1],[1,1],[2,2],[1,2]]

// 1 <= queries.length <= 2 * 10^5