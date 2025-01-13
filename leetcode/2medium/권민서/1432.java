import java.util.*;

class Solution {
    public int maxDiff(int num) {
        String numStr = String.valueOf(num);
        String maxStr = getMax(numStr);
        int maxVal = Integer.parseInt(maxStr);

        String minStr = getMin(numStr);
        int minVal = Integer.parseInt(minStr);

        return maxVal - minVal;
    }

    private String getMax(String numStr) {
        char target = '\0';
        for (char c : numStr.toCharArray()) {
            if (c != '9') {
                target = c;
                break;
            }
        }

        if (target == '\0') return numStr;

        return numStr.replace(target, '9');
    }

    private String getMin(String numStr) {
        char[] numArr = numStr.toCharArray();

        if (numArr[0] != '1') {
            char target = numArr[0];
            for (int i = 0; i < numArr.length; i++) {
                if (numArr[i] == target) numArr[i] = '1';
            }
            return new String(numArr);
        }

        for (int i = 1; i < numArr.length; i++) {
            if (numArr[i] != '0' && numArr[i] != '1') {
                char target = numArr[i];
                for (int j = i; j < numArr.length; j++) {
                    if (numArr[j] == target) numArr[j] = '0';
                }
                break;
            }
        }
        return new String(numArr);
    }
}