import java.util.HashSet;
import java.util.Set;

public class LC_3136 {
    public boolean isValid(String word) {
        if(word.length() < 3) return false;
        int vowelCnt = 0;
        int letterCnt = 0;
        Set<Character> vowel = new HashSet<>(Set.of('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'));
        for(int i=0; i<word.length(); i++){
            Character w = word.charAt(i);
            System.out.println(w);
            if(!Character.isDigit(w) && !Character.isLetter(w)) return false;
            if(Character.isLetter(w)) letterCnt++;
            if(vowel.contains(w)) vowelCnt++;
        }

        if(vowelCnt < 1) return false;
        if((letterCnt - vowelCnt) < 1) return false;

        return true;
    }
}
