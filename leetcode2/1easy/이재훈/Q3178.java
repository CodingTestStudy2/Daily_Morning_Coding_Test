package Leetcode.이재훈;

/*
1. 아이디어 :

- 왼쪽 -> 오른쪽으로 갔다가 오른쪽끝에서 다시 돌아와서 처리

2. 시간복잡도 :
O( n )
3. 자료구조/알고리즘 :
- /
 */

public class Q3005 {

    class Solution {
        public int numberOfChild(int n, int k) {

            int idx = 0;
            boolean pos = false; // false: left to right, true: right to left
            for(int i = 0; i<k; i++) {
                if(!pos) {
                    idx++;
                    if(idx == n -1) pos = true;

                } else {
                    idx--;
                    if(idx == 0) pos = false;

                }
            }
            return idx;
        }
    }
}