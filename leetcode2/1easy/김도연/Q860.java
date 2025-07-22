package Leetcode.김도연;

public class Q860 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int bill: bills) {
            if (bill == 5)
                five++; //5달러 추가
            else if (bill == 10) {
                if (five == 0)
                    return false;
                five--;
                ten++;
            }
            else {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                }
                else if (five >= 3)
                    five -= 3;
                else
                    return false;
            }
        }

        return true;
    }
}
