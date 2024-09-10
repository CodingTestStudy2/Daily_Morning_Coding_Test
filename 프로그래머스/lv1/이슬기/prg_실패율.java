/**
* 구현
* 1 스테이지 1 ~ 개수
* 2 스테이지 2 ~ 개수
{8, 7, 4, 2, 1}
*/
import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Double[][] challenges = new Double[N][2];
        
        for (int i=1; i<N+1; i++) {
            final int idx = i;
            long cnt = Arrays.stream(stages).filter(x -> x >= idx).count();
            long fail = Arrays.stream(stages).filter(x -> x == idx).count();
            if (cnt > 0) {
                challenges[i-1][1] = (double) fail / cnt;
            } else {
                challenges[i-1][1] = (double) 0;
            }
            challenges[i-1][0] = (double) i;
        }
        
        Arrays.sort(challenges, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Double.compare(o1[0], o2[0]);
            }
            return Double.compare(o2[1], o1[1]);
        });
        
        for (int c=0; c<N; c++) {
            answer[c] = (int) Math.round(challenges[c][0]);
        }
        
        //System.out.println(Arrays.deepToString(challenges));
        
        return answer;
    }
}