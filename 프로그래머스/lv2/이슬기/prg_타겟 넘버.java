/**
* 특정 값이 나올 때까지
*/
class Solution {
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        backtracking(0, numbers, target, 0);
        return answer;
    }
    
    public void backtracking(int x, int[] numbers, int target, int scores) {
        if (x == numbers.length) {
            if (scores == target) {
                answer++;
            }
            return;
        }
        backtracking(x+1, numbers, target, scores + numbers[x]);
        backtracking(x+1, numbers, target, scores - numbers[x]);
    }
}