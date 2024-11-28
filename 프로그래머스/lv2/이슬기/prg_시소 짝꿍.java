/**
weights 2, 3, 4
두 수의 최대 공약수로 나눈 값

[처음 시도]
조합으로 계산 -> 시간초과
[두번째 시도]
map으로 중복 계산 줄이기
*/
import java.util.*;

class Solution {
    long answer = 0;
    
    public long solution(int[] weights) {
        int n = weights.length;
        
        Map<Integer, Integer> weightCntMap = new HashMap<>();
        
        for (int weight : weights) {
            weightCntMap.put(weight, weightCntMap.getOrDefault(weight, 0) + 1);
        }
        
        for (int w1 : weightCntMap.keySet()) {
            for (int w2 : weightCntMap.keySet()) {
                if (w1 > w2) continue; // 중복 계산
                
                int gcd = gcd(w1, w2);
                int a = w1 / gcd;
                int b = w2 / gcd;
                
                if (a == 1 && b == 1) {
                    int cnt = weightCntMap.get(w1);
                    answer += (long) cnt * (cnt - 1) / 2;
                } else if (a * b == 2 || (1 < a && a <= 4 && 1 < b && b <= 4)) {
                    answer += (long) weightCntMap.get(w1) * weightCntMap.get(w2);
                }
            }
        }
        
        return answer;
    }
    
    private int gcd(int a, int b) { // 유클리드 호제법
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}