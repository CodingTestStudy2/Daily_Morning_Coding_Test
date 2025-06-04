package 이재훈;

/*
1. 아이디어 :
-  maxPos 가 i랑 같으면 i 는 제일큰수고 앞에 있는값들은 다 채워진 상태
- 그럴때마다 count++ 후 반환
2. 시간복잡도 :
O( n  )
3. 자료구조/알고리즘 :
- /
 */

public class Q1375 {

    class Solution {
        public int numTimesAllBlue(int[] flips) {
            int n = flips.length;
            int maxPos = 0;
            int count =0;


            for(int i = 1; i<=n; i++) {
                maxPos = Math.max(maxPos,flips[i-1]);
                // maxPos 가 i랑 같으면 i 는 제일큰수고 앞에 있는값들은 다 채워진 상태

                if(maxPos == i) {
                    count++;
                }
            }
            return count;
        }
    }
}