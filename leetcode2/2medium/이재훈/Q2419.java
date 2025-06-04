package 이재훈;

/*
1. 아이디어 :

- 받은 인풋값에서 제일 큰 값을 찾고
- 그 값이랑 같으면 카운트를 세주면서 맥스 카운트를 저장한다.
- 다르면 카운트 값을 초기화
- 마지막 값으로 맥스 카운트를 리턴한다.

2. 시간복잡도 :
O( n )
3. 자료구조/알고리즘 :
- /
 */

public class Q1154 {
    class Solution {
        public int longestSubarray(int[] nums) {

            int count = 0;
            int maxValue = 0;
            int maxCount = 0;

            for(int i = 0; i <nums.length; i++) {
                if(maxValue < nums[i]) {
                    maxValue = nums[i];
                }
            }

            for(int i = 0; i < nums.length;i++) {
                if(maxValue == nums[i]) {
                    count++;
                    maxCount = Math.max(count,maxCount);
                } else {
                    count = 0;
                }
            }
            return maxCount;
        }
    }
}