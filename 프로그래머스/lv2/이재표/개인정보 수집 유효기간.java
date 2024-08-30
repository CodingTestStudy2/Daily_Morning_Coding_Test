import java.util.*;
class Solution {
    public static int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        Map<String, String> termMap = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] term = terms[i].split(" ");
            termMap.put(term[0], term[1]);
        }
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            String endDate = calEndDate(privacy[0], termMap.get(privacy[1]));
            if (canNotHavePrivacy(today, endDate) >= 0) {
                list.add(i + 1);
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static int canNotHavePrivacy(String stand, String date) {
        return stand.compareTo(date);
    }

    public static String calEndDate(String date, String month) {
        StringBuilder sb = new StringBuilder();
        String[] splitDate = date.split("\\.");
        Integer dm = Integer.parseInt(splitDate[1]);
        Integer m = Integer.parseInt(month);
        dm = dm + m;
        int plusY = 0;
        while (dm > 12) {
            dm -= 12;
            plusY++;
        }
        Integer dy = Integer.parseInt(splitDate[0]) + plusY;
        sb.append(String.valueOf(dy));
        sb.append(".");
        sb.append(String.format("%02d", dm));
        sb.append(".");
        sb.append(splitDate[2]);
        return sb.toString();
    }

}
