# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    long[] neg;
    long[] pos;
    int mul;
    int n;
    long ans;
    public long solution(int[] sequence) {
        n = sequence.length;
        pos = new long[n];
        neg = new long[n];
        pos[0] = sequence[0];
        neg[0] = -sequence[0];
        mul = -1;
        ans = Math.max(pos[0], neg[0]);
        for (int i=1; i<n; i++){
            pos[i] = Math.max(pos[i-1] + sequence[i] * mul, sequence[i] * mul);
            neg[i] = Math.max(neg[i-1] + sequence[i] * -mul, sequence[i] * -mul);
            ans = Math.max(ans, Math.max(pos[i], neg[i]));
            mul *= -1;
        }
        return ans;
    }
}

'''


