import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String convertNumber=Integer.toString(n,k);
        String[]numberArr=convertNumber.split("0");
        List<Long>list=new ArrayList<>();
         for (String number : numberArr) {
            if (!number.isEmpty()) {
                System.out.println(number);
                list.add(Long.parseLong(number));
            }
        }
        
        for (Long number : list) {
            if (isPrime(number)) {
                answer++;
            }
        }
        return answer;
    }
    private boolean isPrime(long num){
        if (num < 2) return false;
        for (long i = 2; i * i <= num; i++) { 
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}
