import java.util.*;

class Solution {

    public int solution(String[] babbling) {

        String[] str = {"aya", "ye", "woo", "ma"};
        String[] not = {"ayaaya", "yeye", "woowoo", "mama"};
        int answer = 0;


        for (String babb : babbling) {
            boolean flag = true;

            for (int i = 0; i < not.length; i++) {

                if (babb.contains(not[i])) {
                    flag = false;
                }
            }
            if(!flag) continue;

            for (int j = 0; j < str.length; j++) {
                if(babb.contains(str[j])) {
                    babb = babb.replace(str[j], "0");
                }
            }
            babb = babb.replace("0", "");

            if (babb.equals("")) {
                answer++;
            }

        }
        return answer;
    }

}

