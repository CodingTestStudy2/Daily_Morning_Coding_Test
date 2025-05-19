package Leetcode;

/*
1. 아이디어 :
-

2. 시간복잡도 :
O( n + m )
3. 자료구조/알고리즘 :
- / bfs
 */

import java.util.*;

public class Q547 {
    class Solution {
        public int findCircleNum(int[][] isConnected) {

            List<List<Integer>> list = new ArrayList<>();

            for(int i =0;i<isConnected.length;i++) {
                list.add(new ArrayList<>());
            }

            for(int i = 0; i< isConnected.length; i++) {
                for(int j = 0; j<isConnected[0].length;j++) {
                    if(i == j) continue;
                    if(isConnected[i][j] == 1) list.get(i).add(j);
                }
            }
            boolean[] visited = new boolean[isConnected.length];
            int count = 0;
            for(int i = 0; i<isConnected.length; i++) {
                if(visited[i]) continue;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                count++;
                visited[i] = true;
                while(!q.isEmpty()) {
                    int size = q.size();
                    for(int j = 0; j<size; j++) {
                        int province = q.poll();
                        for(int nearProvince : list.get(province)) {
                            if(visited[nearProvince]) continue;
                            visited[nearProvince]= true;
                            q.add(nearProvince);
                        }
                    }
                }
            }

            return count;
        }
    }
}
