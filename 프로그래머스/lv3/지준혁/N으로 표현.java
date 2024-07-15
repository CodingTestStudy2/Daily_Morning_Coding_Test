import java.util.*;

// 테케 한개
class Solution {
    public int solution(int N, int number) {
        
        List<Set<Integer>> dp = new ArrayList<>();
        
        for (int i = 0; i <= 8; ++i)
            dp.add(new HashSet<>());
        
        dp.get(1).add(N);
        
        for (int i = 2; i <= 8; ++i) {
            
            dp.get(i).add(Integer.parseInt((String.valueOf(N).repeat(i))));
            
            for (int j = 1; j < i; ++j) {
                for (var a : dp.get(j)) {
                    for (var b : dp.get(i - j)) {
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);
                        if (b != 0) dp.get(i).add(a / b);
                    }
                }
            }
            
            if (dp.get(i).contains(number)) return i;
        }
        return -1;
    }
}
