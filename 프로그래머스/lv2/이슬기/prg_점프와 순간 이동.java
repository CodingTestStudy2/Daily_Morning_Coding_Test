/**
* 순간이동을 최대한 많이 사용해야함
5
= (1 * 2) * 2 + 1

5를 2진수로 나타낼 때,
101 -> 2가지
5000을 2진수로 나타낼 때,
1001110001000 -> 5가지
*/
import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        String a = Integer.toBinaryString(n);
        
        return a.length() - a.replace("1", "").length();
    }
}