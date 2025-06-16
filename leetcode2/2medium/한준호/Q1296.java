package 한준호;

class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer, Integer> check = new HashMap<>();
        Set<Integer> included = new TreeSet<>();
        for(int i = 0; i<nums.length; i++){
            included.add(nums[i]);
            check.merge(nums[i], 1, Integer::sum);
        }
        for(Integer item : included){
            if(check.get(item) == 0)continue;
            for(int i = item + k - 1; i>=item; i--){
                check.merge(i, -check.get(item), Integer::sum);
                if(check.get(i) < 0) return false;
            }
        }
        return true;
    }
}