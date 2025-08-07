package Leetcode.김도연;

public class Q1317 {
    public int[] getNoZeroIntegers(int n) {
        int answer;
        int[] arr = new int[2];

        for (int i = 1; i <= n/2; i++) {
            if (checkNoZero(i) && checkNoZero(n-i)) {
                arr[0] = i;
                arr[1] = n-i;
                break;
            }
        }

        return arr;
    }

    public boolean checkNoZero(int n) {
        do {
            if (n % 10 == 0)
                return false;
            n = n/10;
        } while (n > 0);
        return true;
    }
}
