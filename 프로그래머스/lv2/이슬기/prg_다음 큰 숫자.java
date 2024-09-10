/**
* bitCount 찾아봄
*/
class Solution {
    public int solution(int n) {
        int xCnt = Integer.bitCount(n);
        //System.out.println(xCnt);
        while (true) {
            n++;
            int x = Integer.bitCount(n);
            
            if (x == xCnt) {
                return n;
            }
        }
    }
}