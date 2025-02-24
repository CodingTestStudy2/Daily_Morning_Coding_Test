public class LC1513 {
    public static final int MAX = 100000 + 1;
    public static final int MODULO = (int) (Math.pow(10,9) + 7);

    public int numSub(String s) {
        s += "0";
        long[] combinations = new long[MAX];

        long prefixSum = 0;
        for (int i = 1; i < MAX; i++) {
            prefixSum += i;
            prefixSum %= MODULO;
            combinations[i] = prefixSum;
        }

        long ret = 0;
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1'){
                counter++;
            }
            else{
                ret += combinations[counter] % MODULO;
                counter=0;
            }
        }
        return (int)ret;
    }
}
