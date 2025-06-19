class RandomizedSet {

    Map<Integer, Integer> map;

    public RandomizedSet() {
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        map.remove(val);
        return true;
    }

    public int getRandom() {
        List<Integer> candi = new ArrayList<>(map.keySet());
        int idx = (int) (Math.random() * candi.size());
        return candi.get(idx);
    }
}

// [      null,        true,      false,    true,      2,         true,     false,       2]
// ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
// [.    [],           [1],      [2],      [2],        [],         [1],       [2],       []]


/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */