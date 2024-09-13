import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int end = 1; 
        int window = w * 2 + 1; 
        for (int i = 0; i < stations.length; i++) {
            if (stations[i] - w > end) {
                int size = stations[i] - w - end; 
                int a = size / window;
                int b = size % window;
                if (b > 0) {
                    answer += a + 1;
                } else {
                    answer += a;
                }
            }
            end = stations[i] + w + 1;
        }
        if (end <= n) {
            int size = n - end + 1;
            int a = size / window;
            int b = size % window;
            if (b > 0) {
                answer += a + 1;
            } else {
                answer += a;
            }
        }
        
        return answer;
    }
}
