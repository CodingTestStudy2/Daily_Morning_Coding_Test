# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :


import java.util.*;
class Solution {
    public int solution(int[] a) {
        int n = a.length;
        int ans = 0;
        if (n < 2) return ans;

        HashMap<Integer, Integer> counter = new HashMap<>();
        for (var num : a) counter.put(num, counter.getOrDefault(num, 0)+1);

        for (var num : counter.keySet()){
            if (counter.get(num) < ans) continue;
            int count = 0;
            int i = 0;
            while (i < n-1) {
                if ((a[i] == num || a[i+1] == num) && a[i] != a[i+1]){
                    count++;
                    i += 2;
                } else {
                    i++;
                }
            }
            ans = Math.max(ans, count);
        }
        return ans*2;

    }
}
'''


