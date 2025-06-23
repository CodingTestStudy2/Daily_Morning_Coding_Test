package Leetcode.한준호;

class Solution {
    public boolean canBeIncreasing(int[] nums) {
        for(int i = 0; i<nums.length; i++){
            boolean tag = true;
            for(int j = 1; j<nums.length; j++){
                if(i==j)continue;
                if(j-1 == i){
                    if(j == 1) continue;
                    if(nums[j-2] >= nums[j]){
                        tag = false;
                        break;
                    }
                }else{
                    if(nums[j-1] >= nums[j]){
                        tag = false;
                        break;
                    }
                }
            }
            if(tag) return true;
        }
        return false;
    }
}