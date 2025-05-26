package Leetcode;

/*
1. 아이디어 :

 - 각 배열의 값들을 set에 넣고 각각 몇개를 담고있는지 확인한다.

2. 시간복잡도 :
O( n )
3. 자료구조/알고리즘 :
- /
 */

import java.util.HashSet;
import java.util.Set;

public class Q2956 {
    class Solution {
        public int[] findIntersectionValues(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int m = nums2.length;

            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();

            int size = n > m ? n : m;

            for(int i = 0; i < size; i++) {
                if(i < m && !set2.contains(nums2[i])) set2.add(nums2[i]);
                if(i < n && !set1.contains(nums1[i])) set1.add(nums1[i]);
            }

            int[] res = new int[2];

            for(int i = 0; i<size; i++) {
                if(i<n) {
                    if(set2.contains(nums1[i])) res[0]++;
                }

                if(i<m) {
                    if(set1.contains(nums2[i])) res[1]++;
                }
            }
            return res;

        }
    }
}