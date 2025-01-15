import java.util.*;

class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int n = s.length();
        int count0 = 0; //0의 개수
        int count1 = 0; //1의 개수
        int left = 0;  //왼쪽 포인터
        int result = 0;  //만족하는 문자열의 개수

        for (int right = 0; right < n; right++) {  //오른쪽 포인터

            if (s.charAt(right) == '0') {
                count0++;
            } else {
                count1++;
            }

            //0과 1의 개수가 k개를 넘어가면 만족할때까지 left포인터의 해당 count감소, left 포인터 이동
            while (count0 > k && count1 > k) {
                if (s.charAt(left) == '0') {
                    count0--;
                } else {
                    count1--;
                }
                left++;
            }
            result += (right - left + 1);
        }

        return result;
    }
}