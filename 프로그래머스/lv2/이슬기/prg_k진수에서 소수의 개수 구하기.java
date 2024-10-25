/**
1. n을 k진수로 바꿈
2. 0을 기준으로 자름 -> 소수 양쪽, 오른쪽, 왼쪽에 0이 있어야
*/
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String changeN = Integer.toString(n, k);
        String[] arr = changeN.split("0");
        
        for (var i=0; i<arr.length; i++) {
            try {
                long cnt = Long.parseLong(arr[i]);
                if (cnt != 1 && cnt != 2) {
                    boolean res = isPrimeNumber(cnt);

                    if (res) answer++;
                } else if (cnt == 2) {
                    answer++;
                }
            } catch (Exception e) { // arr[i] 가 빈 배열이라면
                continue;
            }
        }
        
        return answer;
    }
    
    private boolean isPrimeNumber(long num) {
        for (var i=2; i < Math.sqrt(num) + 1; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}