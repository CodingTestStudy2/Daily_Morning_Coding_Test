package Leetcode.김도연;

public class Q1884{
    public int twoEggDrop(int n) {
        int x = 1;
        while (x * (x + 1) / 2 < n)
            x++;
        return x;
    }
}