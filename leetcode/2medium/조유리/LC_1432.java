public class LC_1432 {
    public int maxDiff(int num) {
        // replace 해서 가장 큰 수 - replace 해서 가장 작은 수
        String s = String.valueOf(num);
        // a : 십진수에서 가장 앞에 있는 수를 9로 Replace
        // 만약 가장 앞에 있는 수가 이미 9이면 그 다음수를 Replace
        char x = '9';
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != '9'){
                x = s.charAt(i);
                break; 
            }
        }
        int a = replace(x, '9', s);

        // b : 
        // 만약 가장 앞에 있는 수가 1이면, 다음 수를 0으로 Replace
        // 만약 가장 앞에 있는 수가 1이 아니면, 해당 수를 1로 Replace
        x = s.charAt(0);
        char y = '1';
        int b = 0;
        if(x == '1'){
            for(int i=1; i<s.length(); i++){
                if(s.charAt(i) != '1' && s.charAt(i) != '0'){
                    x = s.charAt(i);
                    y = '0';
                    break;
                }
            }
        }
        b = replace(x, y, s);

        return a - b;
    }

    // x : source, y : target
    public int replace(char x, char y, String s){
        StringBuilder sb = new StringBuilder(s);
        for(int i=0; i<s.length(); i++){
            if(sb.charAt(i) == x){
                sb.setCharAt(i, y);
            }
        }
        return Integer.parseInt(sb.toString());
    }
}
