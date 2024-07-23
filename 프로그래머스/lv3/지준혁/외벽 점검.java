import java.util.*;

// 1. 원형 쭉 펴주기(시계방향으로만 탐색 가능)
// 2. dist 모든 순열
public class Solution {
    public int solution(int n, int[] weak, int[] dist) {
        List<Integer> weaks = new ArrayList<>();
        
        for (int i = 0; i < weak.length; ++i) weaks.add(weak[i]);
        
        for (int i = 0; i < weak.length - 1; ++i) weaks.add(n + weak[i]);
        
        return 0;
    }
}
