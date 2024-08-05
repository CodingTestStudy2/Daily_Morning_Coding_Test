import java.util.*;

class Solution {
    
    public int solution(String word, String[] pages) {
        
        int[][] pageScore = new int[pages.length][2]; // score, index
        Map<String, Integer> m = new HashMap<>(); // url, score
        
        for (int i = 0; i < pages.length; ++i) {
            
            int score = 0;
						// Score 계산 로직
            
            pageScore[i][0] = score;
            pageScore[i][1] = i;
        }
        Arrays.sort(pageScore, (a, b) -> Integer.compare(b[0], a[0]));
        
        return pageScore[pages.length - 1][1];
    }
}
