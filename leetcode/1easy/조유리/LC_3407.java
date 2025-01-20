public class LC_3407 {
    public boolean hasMatch(String s, String p) {
        String[] w = p.split("\\*");
        int startIdx = 0;
        for(int i=0; i<w.length; i++){
            int lastIdx = match(startIdx, s, w[i]);
            if(lastIdx == -1) return false;
            startIdx = lastIdx;
        }
        return true;
    }

    // 마지막 idx를 반환 (없으면 -1)
    public int match(int start, String s, String p){
        for(int i=start; i<=s.length() - p.length(); i++){
            if(s.substring(i, i+p.length()).equals(p)){
                return i+p.length();
            }
        }
        return -1;
    }
}