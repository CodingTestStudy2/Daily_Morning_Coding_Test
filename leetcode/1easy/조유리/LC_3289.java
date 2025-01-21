import java.util.*;

public class LC_3289 {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        int[] ans = new int[2];
        Arrays.fill(ans, -1);
        for(int num:nums){
            if(visited[num]){
                if(ans[0] == -1){
                    ans[0] = num;
                }
                else{
                    ans[1] = num;
                }
            }
            visited[num] = true;
        }
        Arrays.sort(ans);
        return ans;
    }
}
