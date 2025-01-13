public class LC_1961 {
    public boolean isPrefixString(String s, String[] words) {
        // 처음 K개 문자열로 연결
        int len = s.length();
        int pointer = 0;
        for(String word:words){
            for(int i=0; i<word.length(); i++){
                if(pointer >= len || word.charAt(i) != s.charAt(pointer)){
                    return false;
                }
                pointer++;
            }
            if(pointer == len) return true;
        }
        return false;
    }
}
