package 한준호;

class RandomizedSet {

    Set<Integer> set = new HashSet<>();
    List<Integer> list;
    Map<Integer, Integer> map;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if(map.get(val) != null){
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(map.get(val) == null){
            return false;
        }
        map.put(list.get(list.size() - 1), map.get(val));
        list.set(map.get(val), list.get(list.size() - 1));
        map.remove(val);
        list.remove(list.size() -1);
        return true;
    }

    public int getRandom() {
        int random = (int)(Math.random() * list.size());
        return list.get(random);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */