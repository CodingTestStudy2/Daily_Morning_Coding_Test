class MapSum {

    private static Set<String> keys;
    private static Map<String, Integer> map;

    public MapSum() {
        keys = new HashSet<>();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
        keys.add(key);
    }

    public int sum(String prefix) {
        int sums = 0;
        for (String key : keys) {
            if (key.startsWith(prefix)) sums += map.get(key);
        }

        return sums;
    }
}