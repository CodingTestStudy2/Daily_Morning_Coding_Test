# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''

'''
import java.util.*;
class Leetcode.이재훈.Solution {
    static int n;
    public int solution(String[] friends, String[] gifts) {
        n = friends.length;
        Map<String, Integer> fIdx = new HashMap<>();
        for (int i=0; i<n; i++){
            fIdx.put(friends[i], i);
        }
        int[][] history = new int[n][n];
        int[] pscore = new int[n];
        
        for (String gift : gifts) {
            String[] temp = gift.split(" ");
            int uidx = fIdx.get(temp[0]), vidx = fIdx.get(temp[1]);
            pscore[uidx]++;
            pscore[vidx]--;
            history[uidx][vidx]++;
        }
        
        int[] cScore = new int[n];
        for (int u=0; u<n; u++){
            for (int v=u+1; v<n; v++) {
                if (history[u][v]>history[v][u]){
                    cScore[u]++;
                } else if (history[u][v]<history[v][u]){
                    cScore[v]++;
                } else {
                    if (pscore[u] > pscore[v]) {
                        cScore[u]++;
                    } else if (pscore[u] < pscore[v]) {
                        cScore[v]++;
                    }
                }
            }
        }
        return Arrays.stream(cScore).max().orElse(0);
    }
}'''