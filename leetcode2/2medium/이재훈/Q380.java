package 이재훈;

/*
1. 아이디어 :

- 각 함수가 O(1)로 처리를 해야됨.
- 리스트와 맵으로 처리
- 렌덤 객체를 생성하여 list 사이즈 만큼 처리

2. 시간복잡도 :
O( 1  )
3. 자료구조/알고리즘 :
- /
 */

import java.util.*;

public class Q380 {
    class RandomizedSet {
        Map<Integer, Integer> map; // key: element, value: index
        List<Integer> list;
        Random random = new Random();

        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        public boolean insert(int val) {
            if(map.containsKey(val)) return false;

            int size = list.size();
            map.put(val, size);
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if(!map.containsKey(val)) return false;

            // val 0
            // list [0,1]
            // map [[0,0],[1,1]]
            // list [1]
            // map [[1,1]] - this causes a problem

            // solution
            // swap val and last
            // idx =0;
            // last = 1;

            // list [1]
            // map[[1,0]];
            // remove :

            int idx = map.get(val);
            int last = list.get(list.size()-1);

            list.set(idx, last);
            map.put(last, idx);

            map.remove(val);
            list.remove(list.size()-1);
            return true;
        }

        public int getRandom() {
            int randomInd = random.nextInt(list.size());
            return list.get(randomInd);
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}