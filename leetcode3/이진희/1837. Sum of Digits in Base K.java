/*
1. 아이디어:
   - 10진수로 이뤄진 n을 k진수로 변환 후, 각 자리수의 합 구하기
   - while문으로 직접 자릿수 계산

2. 시간복잡도: O(logN)

3. 자료구조/알고리즘: 진법 변환 원리, 시뮬레이션
*/

class Solution {
    public int sumBase(int n, int k) {

        int ans = 0;
        
        while(n>0) {
            int p = n%k;

            ans += p;
            n/=k;
        }

        return ans;
    }
}