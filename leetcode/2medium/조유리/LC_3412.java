import java.util.HashMap;
import java.util.Stack;

public class LC_3412 {
    class Solution {
        public long calculateScore(String s) {
            long ans = 0;
            int start = 'a';
            HashMap<Integer, Stack<Integer>> map = new HashMap<>();
            for(int i=0; i<s.length(); i++){
                int num = s.charAt(i) - start;
                if(map.containsKey(num)){
                    map.get(num).push(i);
                }
                else{
                    Stack<Integer> stack = new Stack<>();
                    stack.push(i);
                    map.put(num, stack);
                }

                int mirror = 25 - num; 
                if(!map.containsKey(mirror) || map.get(mirror).isEmpty()){
                    continue;
                }
                int a = map.get(num).pop();
                int b = map.get(mirror).pop();
                ans += (a-b);
            }   

            return ans;
        }
    }
}
