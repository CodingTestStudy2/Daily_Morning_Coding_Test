package Leetcode;

/*
1. 아이디어 :
- isPossibleCapacity 함수에서 해당 mid (cap)으로 day를 타겟 데이까지 할수있는지 체크하면서 최소값을 찾음

2. 시간복잡도 :
O( n log n )
3. 자료구조/알고리즘 :
- / binary search
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1011 {
    class Solution {
        public int shipWithinDays(int[] weights, int days) {
            // 1,2,3,4,5,6,7,8,9,10
            // day = 5

            int left = Arrays.stream(weights).max().orElse(0);
            int right = Arrays.stream(weights).sum();
            int cap = 0;

            while(left <= right) {
                int mid = left + (right - left) /2;
                if(isPossibleCapacity(mid, weights, days)) {
                    right = mid -1;
                    cap = mid;
                } else {
                    left = mid + 1;
                }
            }
            return cap;
        }

        public boolean isPossibleCapacity(int cap, int[] weights,int days) {
            int sum = 0;
            int countDay = 1;
            for(int weight :  weights) {
                if(sum + weight > cap) {
                    countDay++;
                    sum = weight;
                    if(countDay > days) return false;
                } else {
                    sum += weight;
                }
            }

            return true;
        }
    }
}