package Leetcode.김도연;

public class Q1952 {
    public boolean isThree(int n) {
        int count = 0;

        for (int i = 1; i <= n/2; i++) {
            if (n % i == 0) {
                if (n == i * i)
                    count++;
                else
                    count += 2;
            }
        }

        if (count == 3)
            return true;
        return false;
    }
}