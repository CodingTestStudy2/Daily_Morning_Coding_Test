/**
주어진대로 구현
*/
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<int[]> q = new LinkedList<>();
        ArrayList<Integer> arrPrior = new ArrayList<>();
        
        for (var p=0; p<priorities.length; p++) {
            q.offer(new int[]{priorities[p], p});
            arrPrior.add(priorities[p]);
        }
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            boolean isBreak = false;
            
            for (int prior : arrPrior) {
                if (prior > now[0]) {
                    q.offer(now);
                    isBreak = true;
                    break;
                }
            }
            if (!isBreak) {
                answer += 1;
                arrPrior.remove(Integer.valueOf(now[0])); // 인덱스가 아닌 특정 값 삭제
                if (now[1] == location) {
                    break;
                }
            }
        }
        
        return answer;
    }
}