class Solution {
    public List<String> cellsInRange(String s) {
        String[] strs = s.split(":");
        char start = strs[0].charAt(0);
        char end = strs[1].charAt(0);
        int min = Math.min(Integer.parseInt(strs[0].substring(1)), Integer.parseInt(strs[1].substring(1)));
        int max = Math.max(Integer.parseInt(strs[0].substring(1)), Integer.parseInt(strs[1].substring(1)));

        List<String> answer = new ArrayList<>();
        for (char i = start; i <= end; i++) {
            for (int j = min; j <= max; j++) {
                answer.add(String.valueOf(i) + j);
            }
        }

        return answer;
    }
}