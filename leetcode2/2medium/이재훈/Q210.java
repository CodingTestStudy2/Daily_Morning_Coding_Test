package 이재훈;/*
1. 아이디어 :

- 인접 리스트를 만든 후에 inDegree에 prerequisite이 각 코스마다 얼마나 있는지 카운트 후에
- prerequisite이 없는 애들부터 순환을 하여 inDegree에서 빼준다.
- prerequisite이 없는 애들을 전부 list에 저장 후 반환을 할때 numCourses와 다르면 빈 int[]을 반환하고
- 아니면 list를 int[] 구조로 변경 후 리턴한다.


2. 시간복잡도 :
O( n + e )
3. 자료구조/알고리즘 :
- /
 */

import java.util.*;

public class Q210 {
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {

            List<List<Integer>> graph = new ArrayList<>();
            int n = numCourses;
            for(int i = 0; i<n;i++) {
                graph.add(new ArrayList<>());
            }

            int[] inDegree = new int[n];

            for(int[] preq : prerequisites) {
                int course = preq[0];
                int pre = preq[1];

                graph.get(pre).add(course);
                inDegree[course]++;
            }


            Queue<Integer> q = new LinkedList<>();
            List<Integer> arr = new ArrayList<>();

            for(int i =0; i<inDegree.length;i++ ) {
                if(inDegree[i] == 0) {
                    q.add(i);
                    arr.add(i);
                }
            }


            while(!q.isEmpty()) {
                int node = q.poll();
                for(int cour : graph.get(node)) {
                    inDegree[cour]--;
                    if(inDegree[cour] == 0) {
                        q.add(cour);
                        arr.add(cour);
                    }
                }
            }

            int[] res = new int[arr.size()];
            for(int i = 0; i<arr.size();i++) {
                res[i] = arr.get(i);
            }
            return n == arr.size() ? res : new int[]{};
        }
    }

}