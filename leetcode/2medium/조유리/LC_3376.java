import java.util.ArrayList;
import java.util.List;

public class LC_3376 {
    class Solution {
        List<Integer> power;
        List<Integer> locks = new ArrayList<>();
        boolean[] visited;
        int inc;
        int ans = Integer.MAX_VALUE;

        public int findMinimumTime(List<Integer> strength, int k) {
            power = strength; 
            inc = k;
            visited = new boolean[strength.size()];
            perm(0);
            return ans;
        }

        // 조합 구하기
        public void perm(int curr){
            if(curr == power.size()){
                ans = Math.min(ans, breakLocks());
                return;
            }
            for(int i=0; i<power.size(); i++){
                if(!visited[i]){
                    locks.add(power.get(i));
                    visited[i] = true;
                    perm(curr+1);
                    locks.remove(locks.size()-1);
                    visited[i] = false;
                }
            }
        }

        // locks 순서대로 진행 했을 때, 결과 값 출력
        public int breakLocks(){
            int time = 0;
            int x = 1;

            for(int i=0; i<locks.size(); i++){
                time += Math.ceil(locks.get(i) / (double)x);
                x += inc;
            }

            return time;
        }
    }
}