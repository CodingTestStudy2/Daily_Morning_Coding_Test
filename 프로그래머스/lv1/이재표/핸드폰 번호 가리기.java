import java.util.*;
class Solution {
    public String solution(String phone_number) {
        String answer = "";
        StringBuilder sb=new StringBuilder();
        int n=phone_number.length();
        sb.append("*".repeat(n-4)).append(phone_number.substring(n-4,n));
        return sb.toString();
    }
}
