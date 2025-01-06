import java.util.LinkedList;
import java.util.Queue;

public class LC_995 {
    public int minKBitFlips(int[] nums, int k) {
        // 모든 배열의 값을 1로 만들기 위한 최소 flip 횟수를 구하라.
        // greedy, 0 나오면 flip
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<nums.length; i++){
            while(!q.isEmpty() && i > q.peek()+k-1){
                q.poll();
            }
            if((nums[i] + q.size()) % 2 == 0){
                if(i+k > nums.length){
                    return -1;
                }
                cnt++;
                q.add(i);
            }
        }
        return cnt;
    }
}
