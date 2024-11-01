//형변환 조심할것, 다시 풀어볼것.
import java.util.*;

class Solution {
    public long solution(int price, int money, int count) {
     
        long total = ((long)count * (2 * price + (count-1)*price) / 2 );
        
        long answer = total <= money ? (long)0 : (long)(total-money);
        return answer;
    }
}
