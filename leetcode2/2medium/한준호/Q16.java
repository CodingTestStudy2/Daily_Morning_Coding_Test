package 한준호;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = 0;
        int distance = Integer.MAX_VALUE;
        for(int i = 0; i< nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                for(int k = j+1; k<nums.length; k++){
                    int now = nums[i] + nums[j] + nums[k];
                    if(Math.abs(target - now) < distance){
                        ans = now;
                        distance = Math.abs(target-now);
                    }
                }
            }
        }
        return ans;
    }
}