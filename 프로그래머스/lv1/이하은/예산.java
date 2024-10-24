/*
주어진 예산 내에서 
최대한 많은 부서에 지원하려고 함.

1 2 3 4 5 -> 9
2 2 3 3 -> 10 

오름차순 정렬 
물품 가격 합산 <= 예산 
*/
import java.util.*;

class Solution {
    public int solution(int[] prices, int budget) {
        Arrays.sort(prices);
        
        int sum = 0;
        int cnt = 0;
        
        for(int price: prices){
            sum += price;
            if(sum <= budget){
                cnt++;
            }
        }
        
        return cnt;
    }
}