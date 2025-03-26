/*
1. 아이디어 :

- for 문 2개를 돌려서 str1, 과 str2를 넣는다.
- prefix와 sumfix를 확인 후 true or false 값 리턴

2. 시간복잡도 :
O( n**3 )
3. 자료구조/알고리즘 :
- / 완전탐색
 */

class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count =0;
        for(int i = 0;i<words.length;i++) {
            for(int j = i+1;j<words.length;j++) {
                if(isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                };
            }
        }
        return count;

    }

    public boolean isPrefixAndSuffix(String str1, String str2) {
        if(str1.length() > str2.length()) return false;

        // prefix
        int minLength = Math.min(str1.length(), str2.length());
        for(int i = 0; i<minLength; i++) {
            if(str1.charAt(i) != str2.charAt(i)) return false;
        }


        // suffix
        int str2LastIdx = str2.length()-1;
        for(int i = minLength -1; i>=0; i--) {
            if(str1.charAt(i) != str2.charAt(str2LastIdx--)) return false;
        }
        return true;
    }
}