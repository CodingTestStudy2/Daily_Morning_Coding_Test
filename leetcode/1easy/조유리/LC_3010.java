import java.util.PriorityQueue;

public class LC_3010 {
    public int minimumCost(int[] nums) {
        int sum = nums[0];
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=1; i<nums.length; i++){
            q.add(nums[i]);
        }
        for(int i=0; i<2; i++){
            sum += q.poll();
        }
        return sum;
    }
}
