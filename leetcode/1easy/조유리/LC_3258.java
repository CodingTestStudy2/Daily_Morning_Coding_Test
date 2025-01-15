public class LC_3258 {
    public int countKConstraintSubstrings(String s, int k) {
        // 부분 문자열의 0 또는 1 이 최대 K개 이다.
        int cnt1 = 0;
        int cnt0 = 0;
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            cnt0 = 0;
            cnt1 = 0;
            for(int j=i; j<s.length(); j++){
                if(s.charAt(j) == '0') cnt0++;
                else cnt1++;
                if(cnt0 <= k || cnt1 <= k) ans++;
            }
        }

        return ans;
    }
}
