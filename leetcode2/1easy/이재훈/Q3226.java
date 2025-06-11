package Leetcode.이재훈;

/*
1. 아이디어 :
 - k에 맞춰서 n을 for loop으로 돌렸을때 k에 있는 1이 n에 없으면 만들수있는 경우가 없기때문 -1을 반환해주고
 - 나머지는 N에서 나온 1의 값과 K에서 나온 1의 값의 차이를 반환해주면 된다.

2. 시간복잡도 :
O( n )
3. 자료구조/알고리즘 :
- /
 */

public class Q3226 {
    class Solution {
        public int minChanges(int n, int k) {
            if(n == k) return 0;
            int ans = -1;
            String biNumForN = Integer.toBinaryString(n);
            String biNumForK = Integer.toBinaryString(k);

            if(biNumForN.length() > biNumForK.length()) {
                StringBuilder sb = new StringBuilder();

                while(biNumForN.length() > biNumForK.length()+sb.length()) {
                    sb.append("0");
                }
                sb.append(biNumForK);
                biNumForK = sb.toString();
            } else if (biNumForN.length() < biNumForK.length()) {
                StringBuilder sb = new StringBuilder();

                while(biNumForK.length() > biNumForN.length()+sb.length()) {
                    sb.append("0");
                }
                sb.append(biNumForN);
                biNumForN = sb.toString();
            }

            int countOnesForK = 0;
            int countOnesForN = 0;

            for(int i = 0; i<biNumForK.length();i++) {
                if(biNumForK.charAt(i) == '1') {
                    countOnesForK++;
                    if(biNumForN.charAt(i) != '1') return ans;
                }
                if(biNumForN.charAt(i) == '1')countOnesForN++;
            }


            return countOnesForN - countOnesForK;
        }


    }
}