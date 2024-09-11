/*
1. 아이디어: 
2. 시간복잡도: O(n)
3. 자료구조:
*/

class Solution {
    public int solution(int n, int m, int[] section) {
        int pos = section[0] + m;
        int ans = 1;
        for (int i = 1; i < section.length; ++i) {
            if (pos > section[i]) {
                continue;
            }
            pos = section[i] + m;
            ++ans;
        }
        return ans;
    }
}
