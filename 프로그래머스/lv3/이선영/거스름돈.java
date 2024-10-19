// https://school.programmers.co.kr/learn/courses/30/lessons/12907 다시풀어볼것!

import java.util.*;
class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        int[] arr = new int[n+1];
        
        arr[0] = 1;
        
        for(int coin : money){
            for(int i=coin; i<=n; i++){
                arr[i] += arr[i-coin];
            }
        }
        
        // System.out.println(Arrays.toString(arr));
        answer = arr[n];
        return answer;
    }
}
