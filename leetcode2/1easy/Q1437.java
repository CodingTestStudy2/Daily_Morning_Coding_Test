package Leetcode;

/*
1. 아이디어 :
 - 1 이 있는 곳들을 방문하면 그전값이랑 비교해서 처리
2. 시간복잡도 :
O( n )
3. 자료구조/알고리즘 :
- / 완전탐색
 */

public class Q1437 {
    class Solution {
        public boolean kLengthApart(int[] nums, int k) {
            int prePos = -1;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] == 1) {
                    if(prePos == -1) {
                        prePos = i;
                        continue;
                    }

                    if((i - prePos -1) < k) return false;
                    prePos = i;
                }

            }
            return true;
        }
    }
}