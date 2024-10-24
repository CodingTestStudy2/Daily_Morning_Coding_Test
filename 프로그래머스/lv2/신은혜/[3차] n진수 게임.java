import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder result = new StringBuilder();
        int max = t*m;
        String s = "";
        int num=0;
        while(s.length()<=max){
            s+=Integer.toString(num,n).toUpperCase();
            num++;
        }

        for(int i=p; i<=max; i+=m){
            result.append(s.charAt(i-1));
        }
        
        return result.toString();
    }
}