package Leetcode.김도연;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Q2034  {
    private Map<Integer, Integer> timestampMap;
    private TreeMap<Integer, Integer> priceCountMap;
    private int latest;

    public Q2034() {
        timestampMap = new HashMap<>();
        priceCountMap = new TreeMap<>();
        latest = 0;
    }

    public void update(int timestamp, int price) {
        if (timestampMap.containsKey(timestamp)) {
            int oldPrice = timestampMap.get(timestamp);
            priceCountMap.put(oldPrice, priceCountMap.get(oldPrice) - 1);
            if (priceCountMap.get(oldPrice)== 0) {
                priceCountMap.remove(oldPrice);
            }
        }

        timestampMap.put(timestamp, price);
        priceCountMap.put(price, priceCountMap.getOrDefault(price, 0) + 1);
        latest = Math.max(latest, timestamp);
    }

    public int current() {
        return timestampMap.get(latest);
    }

    public int maximum() {
        return priceCountMap.lastKey();
    }

    public int minimum() {
        return priceCountMap.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */