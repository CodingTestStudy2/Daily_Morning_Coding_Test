package 이재훈;

/*
1. 아이디어 :
- closestsum 변수로 변동적으로 만들어진 sum이랑 비교후 타켓에 가장 가까운 closestsum을 구한다.

2. 시간복잡도 :
O( n * n )
3. 자료구조/알고리즘 :
- / two pointer
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q16 {
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            int n = nums.length;
            Arrays.sort(nums);
            int closestSum = nums[0] + nums[1] + nums[2];

            for(int i = 0; i<n-2;i++) {
                int left = i + 1;
                int right = n-1;

                while(left<right) {
                    int sum = nums[i] + nums[left] + nums[right];

                    if(Math.abs(sum - target) < Math.abs(closestSum - target)) {
                        closestSum = sum;
                    }

                    if(sum < target) {
                        left++;
                    } else if(sum > target) {
                        right--;
                    } else {
                        //left++;
                        //right--;
                        return sum;
                    }
                }
            }

            return closestSum;
        }
    }
}