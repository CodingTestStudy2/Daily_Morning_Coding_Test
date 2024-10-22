/**
집합
A {1, 2, 3}
B {2, 3, 4}
A ∩ B {2, 3}
A ∪ B {1, 2, 3, 4}
원소의 중복을 허용 -> 집합 자료형보다는 HashMap을 사용하는게 좋을 듯
a 97, z 102
A 65, Z 90
*/
import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        HashMap<String, Integer> A = new HashMap<>();
        HashMap<String, Integer> B = new HashMap<>();
        HashMap<String, Integer> unionMap = new HashMap<>();
        HashMap<String, Integer> interMap = new HashMap<>();
        
        A = getSetsString(str1, A);
        B = getSetsString(str2, B);
        
        for (String key : A.keySet()) {
            if (B.containsKey(key)) {
                if (A.get(key) > B.get(key)) {
                    interMap.put(key, B.get(key));
                } else {
                    interMap.put(key, A.get(key));
                }
            }
            unionMap.put(key, A.get(key));
        }
        
        // 합집합 구하기
        for (String key : B.keySet()) {
            if (unionMap.containsKey(key)) { // 이미 있으면
                if (A.get(key) > B.get(key)) {
                    unionMap.put(key, A.get(key));
                } else {
                    unionMap.put(key, B.get(key));
                }
            } else {
                unionMap.put(key, B.get(key));
            }
        }
        
        double interCnt = getSize(interMap);
        double unionCnt = getSize(unionMap);
        
        if (unionMap.size() > 0) {
            return (int)(interCnt / unionCnt * 65536);
        }
        
        return 65536;
    }
    
    private HashMap<String, Integer> getSetsString(String str, HashMap<String, Integer> map) {
        String st = "";
        for (var i=0; i<str.length(); i++) {
            char a = Character.toUpperCase(str.charAt(i));
            if ((int) a >= 65 && (int) a <= 90) {
                st += String.valueOf(a);
            } else {
                st = "";
                continue;
            }
            
            if (st.length() == 1) continue; // 1글자일 경우
            else if (st.length() == 3) {
                st = st.substring(1, 3); // 2글자로 만들기
            }
            
            map.put(st, map.getOrDefault(st, 0) + 1);
        }
        
        return map;
    }
    
    private int getSize(HashMap<String, Integer> map) {
        int size = 0;
        for (String key : map.keySet()) {
            size += map.get(key);
        }
        return size;
    }
}