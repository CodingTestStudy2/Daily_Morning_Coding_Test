/**
0번 : 1
1번 : 3
*/
class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        
        for (var i=1; i<food.length; i++) {
            for (var j=0; j<food[i] / 2; j++) {
                sb.append(String.valueOf(i));
            }
        }
        
        return sb.toString() + "0" + sb.reverse().toString();
    }
}