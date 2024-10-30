/*
(idx + 1) ~ (n - 1)
-> arr[idx] 보다 작은 원소가 있는지 검사 

N <= 10만
N-1 + N-2 + ... + 1 -> N(N-1) / 2 
*/
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i = 0; i < prices.length; i++){
            int duration = 0;
            
            for(int j = i + 1; j < prices.length; j++){
                duration++; 
                
                // 자신보다 가격이 낮은 경우 탈출 
                if(prices[i] > prices[j]){
                    break;
                }
            }
            
            answer[i] = duration; 
        }
        
        return answer;
    }
}