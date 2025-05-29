class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        int duplicate = 0;
        int[] answer = new int[2];
        int expected_sum = (nums.length*(nums.length+1))/2;
        int actual_sum = 0;

        for(int i = 0; i < nums.length; i++){
            actual_sum = actual_sum + nums[i];
        }

        for(int num : nums){
            if(hash.contains(num)){
                duplicate = num;
            }
            hash.add(num);
        }
        
        int missing = expected_sum - (actual_sum - duplicate);
        System.out.println(missing);
        answer[0] = duplicate;
        answer[1] = missing;
        return answer;
    }
}
