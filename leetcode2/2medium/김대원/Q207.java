class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int n = prerequisites.length;
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        // ai 를 수강하려면 bi를 완료
        for (int i = 0; i < n; i++) {
            int[] prerequisity = prerequisites[i];
            int v1 = prerequisity[0];
            int v2 = prerequisity[1];
            indegree[v2]++;
            graph.get(v1).add(v2);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        boolean answer = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : graph.get(now)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        for (int x : indegree) {
            if (x > 0) {
                answer = false;
                break;
            }
        }

        return answer;
    }
}