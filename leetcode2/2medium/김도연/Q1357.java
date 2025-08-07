package Leetcode.김도연;

import java.util.HashMap;
import java.util.Map;

class Q1357 {
    private int n;
    private int discount;
    private int count;
    private Map<Integer, Integer> priceMap;

    public Q1357(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        this.count = 0;
        this.priceMap = new HashMap<>();

        for (int i = 0; i < products.length; i++)
            priceMap.put(products[i], prices[i]);
    }

    public double getBill(int[] product, int[] amount) {
        count++;
        double total = 0.0;

        for (int i = 0; i < product.length; i++) {
            int productId = product[i];
            int quantity = amount[i];
            total += priceMap.get(productId) * quantity;
        }

        if (count % n == 0)
            total = total - (total * discount / 100.0);

        return total;
    }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */