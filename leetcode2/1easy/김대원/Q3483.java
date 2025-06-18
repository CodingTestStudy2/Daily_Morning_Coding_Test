class Solution {
    public int totalNumbers(int[] digits) {
        Set<String> set = new HashSet<>();
        int n = digits.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                for (int k = 0; k < n; k++) {
                    if (i == k || j == k) continue;
                    String key = digits[i] + "" + digits[j] + "" + digits[k];
                    if (Integer.parseInt(key) % 2 == 0) {
                        if (key.charAt(0) != '0') set.add(key);
                    }
                }
            }
        }

        System.out.println(set);

        return set.size();
    }
}