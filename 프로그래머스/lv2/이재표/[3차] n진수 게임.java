import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String all=convertTo(n,t*m+p);
        for(int i=0;i<t;i++){
            answer+=all.charAt(m*i+(p-1));
        }
        return answer;
    }
    String[]sen={"A","B","C","D","E","F"};
    private String convertTo(int n,int findLen){
        StringBuilder all=new StringBuilder();
        int tmp=0;
        int num=0;
        while(all.length()<findLen){
            num=tmp;
            StringBuilder sb=new StringBuilder();
            while(true){
                int a=num%n;
                if(a-10>=0){
                    sb.append(sen[a-10]);
                }else{
                    sb.append(a);
                }
                num=num/n;
                if(num==0){
                    all.append(sb.reverse());
                    break;
                }
            }
            tmp++;
        }
        return all.toString();
    }
}
