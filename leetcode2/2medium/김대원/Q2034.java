class StockPrice {

    private Map<Integer, Integer> map;
    private TreeMap<Integer, Integer> tmap;
    private int recent;

    public StockPrice() {
        map = new HashMap<>();
        tmap = new TreeMap<>();
        recent = 0;
    }

    public void update(int timestamp, int price) {
        if (map.containsKey(timestamp)) {
            int val = map.get(timestamp);

            map.replace(timestamp, price);
            tmap.replace(val, tmap.get(val) - 1);
            if (tmap.get(val) == 0) tmap.remove(val);
        }

        map.put(timestamp, price);
        tmap.put(price, tmap.getOrDefault(price, 0) + 1);
        recent = Math.max(recent, timestamp);
    }

    public int current() {
        return map.get(recent);
    }

    public int maximum() {
        return tmap.lastKey();
    }

    public int minimum() {
        return tmap.firstKey();
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