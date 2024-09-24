import  java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int n=answers.length;
        int[] answer1=new int[n];
        int[] answer2=new int[n];
        int[] answer3=new int[n];

        int cnt1=0;
        int cnt2=0;
        int cnt3=0;
        
        for(int i=0;i<n;i++){
            if(answers[i]==person1[i%5]){
                cnt1++;
            }
            if(answers[i]==person2[i%8]){
                cnt2++;
            }
            if(answers[i]==person3[i%10]){
                cnt3++;
            }
        }
        
        int max=Math.max(cnt1,cnt2);
        max=Math.max(max,cnt3);
        List<Integer>answer=new ArrayList<>();
        if(max==cnt1){
            answer.add(1);
        }
        if(max==cnt2){
            answer.add(2);
        }
        if(max==cnt3){
            answer.add(3);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();        
    }
}
