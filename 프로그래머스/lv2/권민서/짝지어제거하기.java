
class Solution {

    public int solution(String s) {

        char[] ch = s.toCharArray();
        int lt = 0;
        int rt = 1;

        while(lt <= rt) {
            if (ch[lt] != ch[rt]) {
                lt++;
                rt++;
            } else {

                for (int i = rt + 1; i < ch.length; i++) {
                    ch[i-2] = ch[i];
                }
            }
        }
    }
}
