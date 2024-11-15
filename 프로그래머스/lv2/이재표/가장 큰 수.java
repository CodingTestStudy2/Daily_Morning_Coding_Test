// if(s1.length()==s2.length()){
//                     return o2-o2;
//                 }else if(s1.length()<s2.length()){
//                     for(int i=0;i<s1.length();i++){
//                         if(s1.charAt(i)==s2.charAt(i)){
//                             continue;
//                         }else if(s1.charAt(i)>s2.charAt(i)){
//                             return o1-o2;
//                         }else{
//                             return o2-o1;
//                         }
//                     }
//                     for(int i=s1.length();i<s2.length();i++){
                        
//                     }
//                 }else{
                    
//                 }
import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2); 
            }
        });

        if (strNumbers[0].equals("0")) {
            return "0";
        }

        StringBuilder answer = new StringBuilder();
        for (String num : strNumbers) {
            answer.append(num);
        }

        return answer.toString();
    }
}
