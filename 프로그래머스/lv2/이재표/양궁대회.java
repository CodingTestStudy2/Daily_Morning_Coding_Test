import java.util.*;
class Solution {
     static int max = 0;  
    static int[] answer = new int[11];  

    public static int[] solution(int n, int[] info) {
        max = 0; 
        answer = new int[11]; 
        Arrays.fill(answer, 0);
        
        int[] compare = new int[11]; 
        back(info, n, 0, compare);
        return max != 0 ? answer : new int[]{-1};
    }

    public static void back(int[] info, int n, int idx, int[] compare) {
        if (n == 0 || idx == 10) {  
            if (n > 0) {
                compare[10] += n;  
            }
            
            int cnt = compare(info, compare);  
            if (max <= cnt) {
                if (max < cnt || (max == cnt && isBetter(compare, answer))) { 
                    for (int i = 0; i < answer.length; i++) {
                        answer[i] = compare[i];
                    }
                    max = cnt;
                }
            }
            
            if (n > 0) {
                compare[10] -= n;  
            }
            return;
        }

        int apeachCnt = info[idx];  
        if (apeachCnt + 1 <= n) {  
            compare[idx] = apeachCnt + 1;
            back(info, n - apeachCnt - 1, idx + 1, compare);  
            compare[idx] = 0;  
        }
        back(info, n, idx + 1, compare);
    }

    public static int compare(int[] info, int[] compare) {
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            int cnt = 10 - i;
            if (info[i] < compare[i]) {
                sum += cnt;
            } else if (info[i] > compare[i]) {  
                sum -= cnt;
            }
        }
        return sum; 
    }

    public static boolean isBetter(int[] newCompare, int[] currentAnswer) {
        for (int i = 10; i >= 0; i--) { 
            if (newCompare[i] > currentAnswer[i]) {
                return true;
            } else if (newCompare[i] < currentAnswer[i]) {
                return false;
            }
        }
        return false;
    }
}
