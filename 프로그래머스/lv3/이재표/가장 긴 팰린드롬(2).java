import java.util.*;
// class Solution{
//     String sen;
//     int max=0;
//     public int solution(String s){
//         int answer = 0;
//         sen=s;
//         for(int i=0;i<s.length();i++){
//             bruteforce(i,"");    
//         }
//         return max;
//     }
//     public void bruteforce(int current,String make){
//         if(current>=sen.length()){
//             return;
//         }
//         StringBuilder sb=new StringBuilder(make);
//         sb.append(sen.charAt(current));
//         String newMake=sb.toString();
//         isPalindrome(newMake);        
//         bruteforce(current+1,newMake);
//     }
//     public void isPalindrome(String make){
//         int start=0;
//         int end=make.length()-1;
//         while(start<=end){
//             if(make.charAt(start)==make.charAt(end)){
//                 start++;
//                 end--;
//             }else{
//                 break;
//             }
//         }
//         if(start<=end){
//             return;
//         }else{
//             max=Math.max(max,make.length());
//         }
//     }
// }
class Solution {
    String sen;
    int max = 0;

    public int solution(String s) {
        sen = s;
        for (int i = 0; i < s.length(); i++) {
            palindrome(i, i);   
            palindrome(i, i + 1);
        }
        return max;
    }

    public void palindrome(int left, int right) {
        while (left >= 0 && right < sen.length() && sen.charAt(left) == sen.charAt(right)) {
            max = Math.max(max, right - left + 1);
            left--;
            right++;
        }
    }
}
