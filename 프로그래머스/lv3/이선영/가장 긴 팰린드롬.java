//https://school.programmers.co.kr/learn/courses/30/lessons/12904

import java.util.*;
class Solution {
    public int solution(String s){
        int answer = 1;

        for(int len=s.length(); len>=2; len--){ // 
            for(int start=0; start<=s.length()-len; start++){    
                boolean isPalindrome = true;
                int end = start + len - 1;
                for(int i=0; i<len/2; i++){
                    if(s.charAt(start+i) != s.charAt(end-i)){
                        isPalindrome=false;
                        break;       
                    }
                }
                if(isPalindrome){
                    return len;
                }
            }
            
        }

        return answer;
    }
}
