package 이재훈;

/*
1. 아이디어 :
- I ~j 를 제외한 나머지가 increasing 인지 확인함

2. 시간복잡도 :
O( n **3)
3. 자료구조/알고리즘 :
- / 완전 탐색
 */

public class Q2970 {
    class Solution {

        public int incremovableSubarrayCount(int[] nums) {
            int count = 0;

            for(int i = 0; i<nums.length; i++) {
                for(int j = i; j<nums.length;j++) {
                    boolean isFlag = true;
                    int prev = Integer.MIN_VALUE;
                    for(int k= 0; k<nums.length; k++) {
                        if(k >= i && k <= j) continue;
                        if(nums[k] <= prev) {
                            isFlag = false;
                            break;
                        }
                        prev = nums[k];
                    }
                    if(isFlag) count++;
                }
            }
            return count;
        }
    }
}