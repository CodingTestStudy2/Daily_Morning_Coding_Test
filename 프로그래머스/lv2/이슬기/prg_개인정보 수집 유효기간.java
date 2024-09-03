import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        /** 약관 기간 -> 년, 월
        * 6 -> 0, 6
        * 12 -> 1, 0
        * 3 -> 0, 3
        */
        HashMap<String, int[]> termsMap = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        
        for (String term : terms) {
            String[] t = term.split(" ");
            int period = Integer.parseInt(t[1]);
            termsMap.put(t[0], new int[]{period/12, period%12});
        }
        
        for (int i=0; i<privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            String[] date = privacy[0].split("[.]");
            
            int yyyy = Integer.parseInt(date[0]) + termsMap.get(privacy[1])[0];
            int mm = Integer.parseInt(date[1]) + termsMap.get(privacy[1])[1];
            if (mm > 12) {
                yyyy++;
                mm -= 12;
            }
            String zero = mm >= 10 ? "" : "0";
            String value = yyyy + "." + zero + mm + "." + date[2];
            // System.out.println(value);
            // System.out.println(value.compareTo(today));
            if (value.compareTo(today) <= 0) {
                result.add(i+1);
            }
        }
        
        answer = result.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
}