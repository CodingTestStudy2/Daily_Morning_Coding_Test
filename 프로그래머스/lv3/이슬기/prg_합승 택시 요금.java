/**
S -> M, M -> B
S -> M, M -> A
플로이드 워셜?
*/
import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        int[][] graph = new int[n+1][n+1];
        for (int i=0; i<n+1; i++) {
            Arrays.fill(graph[i], 20000000);
        }
        
        for (int[] fare : fares) {
            graph[fare[0]][fare[1]] = fare[2];
            graph[fare[1]][fare[0]] = fare[2];
        }
        
        for (int k=1; k<n+1; k++) {
            for (int i=1; i<n+1; i++) {
                for (int j=1; j<n+1; j++) {
                    if (i == j) {
                        graph[i][j] = 0;
                        continue;
                    }
                    
                    graph[i][j] = Math.min(graph[i][k] + graph[k][j], graph[i][j]);
                }
            }
        }
        
        for (int i=1; i<n+1; i++) {
            int cnt = graph[s][i];
            for (int j=1; j<n+1; j++) {
                if (j == a) {
                    cnt += graph[i][j];
                } else if (j == b) {
                    cnt += graph[i][j];
                }
            }
            answer = Math.min(cnt, answer);
        }
        
        return answer;
    }
}