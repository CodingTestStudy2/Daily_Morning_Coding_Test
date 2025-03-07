import java.util.*;

class Solution {


    /*
     * 1. 아이디어 :
     *      투 포인터로 풀 수 있습니다.
     * 2. 시간복잡도 :
     *      O( n^n )
     * 3. 자료구조/알고리즘 :
     *      슬라이딩 윈도우
     * */


        public static int maximumLengthSubstring(String s) {
        char[] sArray = s.toCharArray();
        int start = 0;
        int end = 0;
        int size = sArray.length;

        int max = 0;

        while(start<= end && end<size){
            Map<Character, Integer> characterCnt = new HashMap<>();
            int sum=0;

            for(int i=start; i<=end; i++){
                sum++;

                char c = sArray[i];
                int cnt = characterCnt.getOrDefault(c,0);
                if(cnt==2){
                    start++;
                    break;
                }else{
                    characterCnt.put(c,cnt+1);
                    if(i==end){
                        max = Math.max(max,sum);
                        end++;
                        break;

                    }

                }


            }



        }
        return max;

    }
}
