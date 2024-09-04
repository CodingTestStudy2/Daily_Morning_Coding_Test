/**
* 네트워크
* BFS 사용
*/
import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                answer++; // 네트워크 추가
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                visited[i] = true;
                while (!q.isEmpty()) {
                    int now = q.poll();
                    for (int c=0; c<n; c++) {
                        if (c == now) continue;
                        if (computers[now][c] == 1 && !visited[c]) {
                            q.add(c);
                            visited[c] = true;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}