import java.util.*;
class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        
        String s1 = "";
        String s2 = "";
        for(int i=arr.length-1; i>=0; i--){
            if('A'<=arr[i]&&arr[i]<='Z') s2+=arr[i];
            else s1+=arr[i];
        }
        
        return s1+s2;
    }
}