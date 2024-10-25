import java.util.*;

class Solution {    
    static boolean isPrime(long n){
        for(long i=2; i<=Math.sqrt(n); i++){
            if(n%i==0) return false;
        }
        return true;
    }
    
    public int solution(int n, int k) {
        String s = Integer.toString(n,k);
        String[] list = s.split("0");
        
        int cnt = 0;
        for(String num : list){
            if(num.equals("")) continue;
            long a = Long.parseLong(num);
            if(a!=1 && isPrime(a)){
                cnt++;
            }
        }
        
        return cnt;
    }
}