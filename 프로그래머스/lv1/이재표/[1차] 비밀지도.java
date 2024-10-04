import java.util.*;
class Solution {
    int len;
    public String[] solution(int n, int[] arr1, int[] arr2) {
        len=n;
        String[] answer = new String[n];
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            String b1=Integer.toBinaryString(arr1[i]);
            String b2=Integer.toBinaryString(arr2[i]);
            answer[i]=calOr(b1,b2);
        }
        return answer;
    }
    public String calOr(String s1,String s2){
        StringBuilder sb=new StringBuilder();
        s2=fill(s2);
        s1=fill(s1);
        for(int i=0;i<s1.length();i++){
            char c1=s1.charAt(i);
            char c2=s2.charAt(i);
            if(c1=='1'||c2=='1'){
                sb.append('#');
            }else{
                sb.append(' ');
            }
        }
        return sb.toString();
    }
    public String fill(String s1){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<len-s1.length();i++){
            sb.append('0');
        }
        sb.append(s1);
        return sb.toString();
    }
}
