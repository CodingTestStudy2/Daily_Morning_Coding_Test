/**
전화번호부
*/
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (var i=1; i<phone_book.length; i++) {
            if (phone_book[i].startsWith(phone_book[i-1])) {
                return false;
            }
        }
        
        return true;
    }
}