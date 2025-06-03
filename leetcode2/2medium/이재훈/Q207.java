package 이재훈;

/*
1. 아이디어 :
-

2. 시간복잡도 :
O( n + m )
3. 자료구조/알고리즘 :
- / bfs
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Q207 {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if(prerequisites.length == 0) return true;

            List<List<Integer>> list = new ArrayList<>();
            for(int i = 0; i< numCourses;i++) {
                list.add(new ArrayList<>());
            }

            for(int[] prerequisite : prerequisites) {
                int class1 = prerequisite[0];
                int class2 = prerequisite[1];

                list.get(class1).add(class2);
            }

            int[] inDegree = new int[numCourses];
            for (int u = 0; u < numCourses; u++) {
                for (int node : list.get(u)) {
                    inDegree[node]++;
                }
            }
            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == 0) queue.offer(i);
            }

            int visitedCount = 0;
            while (!queue.isEmpty()) {
                int u = queue.poll();
                visitedCount++;
                for (int node : list.get(u)) {
                    if (--inDegree[node] == 0) {
                        queue.offer(node);
                    }
                }
            }

            return visitedCount == numCourses;
        }
    }
}
