import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<elements.length;i++){
            int sum=0;
            int start=0;
            int end=start+i;
            for(int j=start;j<=end;j++){
                sum+=elements[j];
            }
            set.add(sum);
            for(int j=start+1;j<elements.length;j++){
                start+=1;
                end+=1;
                sum+=elements[(end)%elements.length];
                sum-=elements[start-1];
                set.add(sum);
            }
        }
        return set.size();
    }
}
