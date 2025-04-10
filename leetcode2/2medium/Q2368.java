package Leetcode;

/*
1. 아이디어 :

- 인접 리스트 생성 후
- bfs로 각 레벨 하나씩 내려가면서 확인

2. 시간복잡도 :
O( n  )
3. 자료구조/알고리즘 :
- / bfs
 */

public class Q2368 {
    class Solution {
        public int reachableNodes(int n, int[][] edges, int[] restricted) {
            List<List<Integer>> graph = new ArrayList<>();
            for(int i = 0; i<n;i++) graph.add(new ArrayList<>());

            for(int[] edge : edges) {
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
            }

            Set<Integer> restrictedSet = new HashSet<>();
            for(int r : restricted) {
                restrictedSet.add(r);
            }

            boolean[] visited = new boolean[n];
            Queue<Integer> queue = new LinkedList<>();

            queue.offer(0);
            visited[0] = true;

            int count = 0;

            while(!queue.isEmpty()) {
                int node = queue.poll();
                count++;

                for(int neighbour : graph.get(node)) {
                    if(!visited[neighbour] && !restrictedSet.contains(neighbour)) {
                        visited[neighbour] = true;
                        queue.offer(neighbour);
                    }
                }
            }
            return count;
        }


    }
}