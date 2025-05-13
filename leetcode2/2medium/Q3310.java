package Leetcode;

/*
1. 아이디어 :

- 인접 리스트 생성 후
- bfs로 하나씩 빼내서 infected된 애들을 전부 저장
- 만약 infected된애들외에 다른애들이 그룹내에 있다면 전체를 리턴
- 없다면 inflected된 애들 제외하고 나머지 저장 후 리턴

2. 시간복잡도 :
O( n * m )
3. 자료구조/알고리즘 :
- / bfs
 */

import java.util.*;

public class Q3310 {
    class Solution {
        public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
            List<Integer> res = new ArrayList<>();

            // 인접리스트 만들기
            List<Integer>[] originalList = new List[n];
            List<Integer>[] callerList = new List[n];
            for(int i =0;i < n;i++) {
                res.add(i);
                originalList[i] = new ArrayList<>();
                callerList[i] = new ArrayList<>();
            }
            for(int[] inv : invocations) {
                int a = inv[0];
                int b = inv[1];

                originalList[a].add(b);
                callerList[b].add(a);
            }

            boolean[] bugs = new boolean[n];
            Queue<Integer> q = new LinkedList<>();
            q.offer(k);
            bugs[k] = true;

            // find all bugs
            while(!q.isEmpty()) {
                int bug = q.poll();
                for(int b : originalList[bug]) {
                    if(!bugs[b]) {
                        bugs[b] = true;
                        q.add(b);
                    }
                }
            }

            // 만약 버그 노드 제외하고 다른 애들이 해당 그룹에 있을경우 전체를 반환
            for(int i = 0; i<n; i++) {
                if(!bugs[i]) continue;
                for(int caller : callerList[i]) {
                    if(!bugs[caller]) return res;
                }
            }

            // 아닐경우에는 bugs에 있는 애들을 제외하고 처리
            res = new ArrayList<>();
            for(int i = 0; i<n;i++) {
                if(!bugs[i]) res.add(i);
            }
            return res;
        }
    }
}