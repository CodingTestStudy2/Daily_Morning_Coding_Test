import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        // 1. 인용 횟수를 내림차순으로 정렬
        Arrays.sort(citations);
        
        int n = citations.length;
        
        // 2. 인용 횟수를 뒤에서부터 보면서 H-Index 계산
        for (int i = 0; i < n; i++) {
            int h = n - i; // 현재 논문보다 많이 인용된 논문 수
            if (citations[i] >= h && citations[i] > i) {
                return h;
            }
        }
        
        // 3. 모든 논문이 H-Index 조건을 만족하지 못한 경우
        return 0;
    }
}
