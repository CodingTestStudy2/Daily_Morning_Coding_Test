package 이재훈;

/*
1. 아이디어 :
- 인접리스트를 만든 후 조상들의 숫자를 각 노드가 얼마나 가지고 있는지 저장
- 최상위 조상부터 연결되어있는 후손들의 정보를 가져와서 해당 후손들의 정보를 저장한다.
- 그리고 조상들의 정보를 처리할때마다 각 노드의 조상 연결수를 줄여주면서 0이 됬을때 큐에 넣어서 해당 노드의 후손들의 정보를 가져와 다시 똑같은 처리를 한다.
- 마지막에 데이터를 저장하고 반환
2. 시간복잡도 :
O( n **3)
3. 자료구조/알고리즘 :
- / bfs
 */

import java.util.*;

public class Q2192 {
    class Solution {
        public List<List<Integer>> getAncestors(int n, int[][] edges) {
            List<List<Integer>> graph = new ArrayList<>();
            int[] inDegree = new int[n];
            List<TreeSet<Integer>> ancestors = new ArrayList<>();
            for(int i = 0; i<n ;i++) {
                graph.add(new ArrayList<>());
                ancestors.add(new TreeSet<>());
            }
            // [
            //     [3, 4],      // 0 → 3, 4
            //     [3],         // 1 → 3
            //     [4, 7],      // 2 → 4, 7
            //     [5, 6, 7],   // 3 → 5, 6, 7
            //     [6],         // 4 → 6
            //     [],          // 5 has no outgoing edges
            //     [],          // 6 has no outgoing edges
            //     []           // 7 has no outgoing edges
            // ]

            for(int[] edge : edges) {
                graph.get(edge[0]).add(edge[1]);
                inDegree[edge[1]]++; // 각 노드의 조상 수를 저장
            }

            Queue<Integer> q = new LinkedList<>();
            for(int i = 0; i< n; i++) {
                if(inDegree[i] == 0) {
                    q.offer(i);

                }
            }

            while(!q.isEmpty()) {
                int node = q.poll(); // 0, 1, 2
                for(int next : graph.get(node)) { // node =0, next = 3 4
                    ancestors.get(next).add(node); // 조상 추가
                    ancestors.get(next).addAll(ancestors.get(node)); // 간접 조상들 정보 추가

                    inDegree[next]--;
                    if(inDegree[next] == 0) {
                        q.offer(next);
                    }
                }
            }

            List<List<Integer>> res = new ArrayList<>();
            for(TreeSet<Integer> set : ancestors) {
                res.add(new ArrayList<>(set));
            }

            return res;


        }
    }
}