public class LC_2409 {
    class Solution {
        static int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
            boolean[] visited = new boolean[365+1];
            int ans = 0;
            for(int i=dateToInt(arriveAlice); i<=dateToInt(leaveAlice); i++){
                visited[i] = true;
            }
            for(int i=dateToInt(arriveBob); i<=dateToInt(leaveBob); i++){
                if(visited[i]) ans++;
            }
            return ans;
        }
    
        public int dateToInt(String stringDate){
            String[] md = stringDate.split("-");
            int month = Integer.parseInt(md[0]);
            int day = Integer.parseInt(md[1]);
            int date = 0;
            for(int i=1; i<month; i++){
                date += days[i];
            }
            date += day;
            return date;
        }
    }
}