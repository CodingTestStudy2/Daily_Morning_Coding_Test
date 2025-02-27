import java.util.LinkedList;

public class LC_3069 {
    class Solution {
        public int[] resultArray(int[] nums) {
            LinkedList<Integer> arr1 = new LinkedList<>();
            LinkedList<Integer> arr2 = new LinkedList<>();
            arr1.add(nums[0]);
            arr2.add(nums[1]);
            for(int i=2; i<nums.length; i++){
                if(arr1.getLast() > arr2.getLast()){
                    arr1.add(nums[i]);
                }
                else{
                    arr2.add(nums[i]);
                }
            }
            int[] ans = new int[nums.length];
            int idx = 0;
            for(int i=0; i<arr1.size(); i++){
                ans[idx] = arr1.get(i);
                idx++;
            }
            for(int i=0; i<arr2.size(); i++){
                ans[idx] = arr2.get(i);
                idx++;
            }
            return ans;
        }
    }
}
