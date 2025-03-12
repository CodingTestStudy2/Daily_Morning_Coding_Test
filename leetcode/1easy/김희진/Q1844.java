public class Q1844 {

    public String replaceDigits(String s) {
        char[] charArr = s.toCharArray();
        for (int i = 1; i < charArr.length; i += 2) {
            // a + '2' - '0' = a + 2 = c -> 97(a) + 2(right shift) = 99(c)
            charArr[i] = (char)(charArr[i - 1] + charArr[i] - '0');
        }
        return String.valueOf(charArr);
    }

}
