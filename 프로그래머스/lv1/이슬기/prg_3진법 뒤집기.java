/**
* 3진법으로 만들고 10진법으로 변환
*/

class Solution {
    public int solution(int n) {
        String a = Integer.toString(n, 3); // 10진법 -> 3진법
        StringBuilder sb = new StringBuilder();
        
        for (int i=a.length()-1; i>=0; i--) {
            sb.append(String.valueOf(a.charAt(i)));
        }
        
        return Integer.parseInt(sb.toString(), 3); // 3진법 -> 10진법
    }
}