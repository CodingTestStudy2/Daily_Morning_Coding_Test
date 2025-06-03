package 이재훈;

/*
1. 아이디어 :

- i 로 돌아가면서 j k의 값을 각 left right 로 처리
- 중복값처리

2. 시간복잡도 :
O( n log n )
3. 자료구조/알고리즘 :
- / two pointer
 */

public class Q15 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();

            for(int i = 0; i<nums.length-2;i++) {
                if(i > 0 && nums[i] == nums[i-1]) continue;
                int left = i+1;
                int right = nums.length-1;

                while(left <right) {
                    if(nums[i]+nums[left]+nums[right] == 0) {
                        res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                        left++;
                        right--;
                        while(left<right && nums[left] == nums[left-1]) left++;
                        while(left<right && nums[right] == nums[right+1]) right--;
                    } else if(nums[i]+nums[left]+nums[right] > 0) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }

            return res;
        }
    }
}