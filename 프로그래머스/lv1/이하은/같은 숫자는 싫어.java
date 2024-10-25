import java.util.*;

/*
(1, 0)
(3, 2)
(0, 4)
(1, 5)
-> 같은 숫자가 나와도 인접한 인덱스가 아니면 추가!
*/
public class Solution {
    class Pair {
        private int x;
        private int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getFirst(){
            return x;
        }

        public int getSecond(){
            return y;
        }
    }
    
    ArrayList<Pair> temp = new ArrayList<>();
    
    public int[] solution(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            if(temp.isEmpty()){
                temp.add(new Pair(arr[i], i));
                continue;
            }
            
            if(arr[i - 1] == arr[i]){
                continue;
            }

            int idx = contains(arr[i]);
            if(idx == -1){
                temp.add(new Pair(arr[i], i));
            }else{
                if(i - idx != 1){
                    temp.add(new Pair(arr[i], i));
                }
            }
        }
        
        int[] answer = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++)
            answer[i] = temp.get(i).getFirst();

        return answer;
    }
    
    int contains(Integer num){
        for(Pair pair: temp){
            if (pair.getFirst() == num) {
                return pair.getSecond();
            }
        }
        
        return -1;
    }
}