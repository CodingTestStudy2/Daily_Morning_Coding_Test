import java.util.*;
class Solution {
    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, Integer> map = new HashMap<>(); 
        for (int i = 0; i < enroll.length; i++) {
            map.put(enroll[i], i);
        }
        for (int i = 0; i < seller.length; i++) {
            int sellerIdx = map.get(seller[i]);
            int money = amount[i] * 100; 
            while (true) {
                int commission = money / 10;
                answer[sellerIdx] += (money - commission); 
                
                if (referral[sellerIdx].equals("-")) { 
                    break;
                }
                
                sellerIdx = map.get(referral[sellerIdx]); 
                money = commission;  
                
                if (money == 0) break; 
            }
        }
        return answer;
    }
}
