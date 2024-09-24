import java.util.*;

/*
O(N), O(NlogN) N <= 5만

모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값
최대 2명까지만 탑승 가능 

무게가 적은 + 많은 사람 같이 묶어서 태우기 
*/
class Solution {
    public int solution(int[] arr, int limit) {
        int cnt = 0;
        Arrays.sort(arr);
        
        // 50 50 70 80 
        // 50 70 80 
        int l = 0, r = arr.length - 1;
        while(l <= r){
            if(arr[l] + arr[r] <= limit) l++; 
            r--;
            cnt++;
        }
        
        return cnt;
    }
}