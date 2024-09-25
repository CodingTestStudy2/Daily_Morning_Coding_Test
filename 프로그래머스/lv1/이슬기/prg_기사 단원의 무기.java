/**
* 약수의 개수 세기
-> 개수 초과 시, power로 바꾸기
*/
import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int[] result = new int[number+1];
        Arrays.fill(result, 1); // 1로 나눌 수 있음
        result[0] = 0;
        
        for (int i=2; i<number+1; i++) {
            for (int j=i; j<number+1; j+=i) {
                result[j] += 1;
            }
        }
        // System.out.println(Arrays.toString(result));
        
        for (int n=0; n<number+1; n++) {
            if (result[n] > limit) result[n] = power;
        }
        
        return Arrays.stream(result).sum();
    }
}