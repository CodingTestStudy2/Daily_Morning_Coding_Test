package Leetcode.이재훈;

/*
1. 아이디어 :

 - arr를 sorting 한 후에 arr길이의 5%를 구하고
 - arr길이에서 앞 뒤로 5%만큼 뺀 나머지 값을 저장한 후
 - 5%를 뺀 arr의 길이를 나눠주면 mean값이 구해짐


2. 시간복잡도 :
O( n log n )
3. 자료구조/알고리즘 :
- /
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1619 {
    class Solution {
        public double trimMean(int[] arr) {

            Arrays.sort(arr);
            double res = 0.0;
            int n = (int) (arr.length * 0.05);

            for(int i = n; i < arr.length-n;i++) {
                res += arr[i];
            }

            int length = arr.length - (n*2);
            res /= length;

            return res;
        }
    }
}