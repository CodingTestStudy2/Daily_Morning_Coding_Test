public class LC_2506 {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int roundAmount = Math.round(purchaseAmount / 10.0f) * 10;
        return 100 - roundAmount;
    }
}
