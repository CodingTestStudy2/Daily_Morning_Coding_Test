class Solution {
    public int minMaxDifference(int num) {
        int answer = Integer.MIN_VALUE;
        int max = 0;
        for (int i = 0; i < String.valueOf(num).length(); i++) {
            String str = String.valueOf(num);
            str = str.replaceAll(String.valueOf(str.charAt(i)), "9");
            max = Math.max(max, Integer.parseInt(str));
        }

        for (int i = 0; i < String.valueOf(num).length(); i++) {
            String str = String.valueOf(num);
            str = str.replaceAll(String.valueOf(str.charAt(i)), "0");

            answer = Math.max(answer, max - Integer.parseInt(str));
        }

        return answer;
    }
}