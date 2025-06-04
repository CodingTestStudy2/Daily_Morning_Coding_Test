package 이재훈;

/*
1. 아이디어 :
- prefixsum을 이용해서
2. 시간복잡도 :
O( n)
3. 자료구조/알고리즘 :
- / prefixsum
 */

public class Q3096 {
    class Solution {
        public int minimumLevels(int[] possible) {
            int length = possible.length;
            int[] prefixSum = new int[length + 1];
            prefixSum[0] = 0;
            for(int i = 0; i <= length; i++) {
                if(i < length && possible[i] == 0) possible[i] = -1;

                if(i != 0) prefixSum[i] = prefixSum[i-1] + possible[i-1];
            }


            for(int i = 1; i < length; i++) {
                if(prefixSum[i] - prefixSum[0] > prefixSum[length] - prefixSum[i]) return i;
            }
            return -1;

        }
    }
}