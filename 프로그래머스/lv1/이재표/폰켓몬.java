import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int n=nums.length/2;
        Set<Integer>keys=map.keySet();
        if(keys.size()>n){
            return n;
        }
        return keys.size();
    }
}
