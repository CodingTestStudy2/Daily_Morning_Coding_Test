package 이재훈;

/*
1. 아이디어 :

- 앞에서부터 0을 찾아서 0을 만날때 마다 3개씩 바꿔주고 마지막에 3개가 안남아있으면 끝

2. 시간복잡도 :
O( n  )
3. 자료구조/알고리즘 :
- /
 */

public class Q3191 {
    class Solution {
        public int minOperations(int[] nums) {

            int count = 0;
            for(int i = 0; i< nums.length; i++) {
                if(nums[i] ==0) {
                    if(i+2 < nums.length) {
                        count++;
                        for(int j = i; j < i+3 && j<nums.length;j++) {
                            //System.out.println(j);
                            nums[j] = nums[j] == 0 ? 1 : 0;
                        }
                        //System.out.println();
                    }

                }
            }
            for(int i =nums.length-1;i>=0; i--) {
                if(nums[i] == 0) return -1;
            }
            return count;
        }
    }
}