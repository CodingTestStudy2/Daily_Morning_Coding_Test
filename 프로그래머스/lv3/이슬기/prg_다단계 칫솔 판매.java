/**
부모노드 
*/
import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        int[] answer = new int[n];
        Arrays.fill(answer, 0);
        
        HashMap<String, Integer> dict = new HashMap<>();
        int[] parent = new int[n]; // 부모 그래프
        Arrays.fill(parent, -1); // -1이면 부모노드가 없음
        
        for (var i=0; i<n; i++) {
            dict.put(enroll[i], i);
        }
        
        for (var i=0; i<n; i++) {
            if (referral[i].equals("-")) continue;
            parent[i] = dict.get(referral[i]);
        }
        
        for (var i=0; i<seller.length; i++) {
            int cnt = amount[i] * 100;
            int sell = dict.get(seller[i]);
            answer[sell] += cnt - cnt / 10; // 90% 추가
            while (parent[sell] != -1) {
                if (cnt / 10 == 0) { // 더 이상 나눌 것이 없을 경우
                    break;
                }
                cnt = cnt / 10;
                sell = parent[sell];
                answer[sell] += cnt - cnt / 10;
            }
        }
        
        return answer;
    }
}