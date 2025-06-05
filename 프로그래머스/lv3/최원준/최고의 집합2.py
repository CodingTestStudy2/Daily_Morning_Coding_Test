# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(log n)
3. 자료구조 :

'''


'''
import java.util.*;
<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution {
=======
class Leetcode.이재훈.Solution {
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    public int[] solution(int n, int s) {
        if (s<n) return new int[]{-1};
        
        int[] ans = new int[n];
        int idx = 0;
        while (n>0){
            int temp = s/n;
            ans[idx++]=temp;
            s -= temp;
            n--;
        }
        return ans;
    }
}'''
