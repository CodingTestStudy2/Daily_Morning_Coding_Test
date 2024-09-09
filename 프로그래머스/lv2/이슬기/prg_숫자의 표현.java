/**
* 연속된 부분수열의 합
*/
class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] numbers = new int[n];
        for (int i=0; i<n; i++) {
            numbers[i] = i+1;
        }
        
        int value = 0;
        int point = 0;
        for (int i=0; i<n; i++){
            while (value < n && point < n) {
                value += numbers[point];
                point ++;
            }
            if (value == n) {
                answer ++;
            }
            value -= numbers[i];
        }
        
        return answer;
    }
}