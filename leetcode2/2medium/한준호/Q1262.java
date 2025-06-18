package 한준호;

class Solution {
    public int maxSumDivThree(int[] nums) {
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();
        int ans = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]%3 == 1){
                one.add(nums[i]);
            }else if (nums[i]%3 == 2){
                two.add(nums[i]);
            }
            ans += nums[i];
        }
        Collections.sort(one);
        Collections.sort(two);
        if(ans%3==1){
            int possible1 = 0;
            int possible2 = 0;
            if(one.size()>=1){
                possible1 = ans - one.get(0);
            }
            if(two.size()>=2){
                possible2 = ans - two.get(0) - two.get(1);
            }
            ans = Math.max(possible1, possible2);
        }
        if(ans%3==2){
            int possible1 = 0;
            int possible2 = 0;
            if(one.size()>=2){
                possible1 = ans - one.get(0)-one.get(1);
            }
            if(two.size()>=1){
                possible2 = ans - two.get(0);
            }
            ans = Math.max(possible1, possible2);
        }
        return ans;
    }
}