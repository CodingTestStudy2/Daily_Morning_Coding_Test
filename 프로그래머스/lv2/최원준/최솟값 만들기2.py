# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''


'''
import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int n = A.length;
        Arrays.sort(A);
        Arrays.sort(B);

        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            ans += A[i] * B[n-i-1];
        }
        return ans;
    }
}
'''