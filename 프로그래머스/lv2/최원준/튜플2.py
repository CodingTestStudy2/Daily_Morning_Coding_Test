# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution {
=======
class Leetcode.이재훈.Solution {
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    public int[] solution(String s) {
        s = s.replace("{{", "").replace("}}", "").replace("},{", " ");
        String[] sets = s.split(" ");
        List<String[]> setList = new ArrayList<>();
        for (String set : sets) {
            String[] numbers = set.split(",");
            setList.add(numbers);
        }
        setList.sort(Comparator.comparingInt(arr -> arr.length));

        Set<String> visited = new HashSet<>();
        int[] ans = new int[setList.size()];
        for (int i=0; i<setList.size(); i++){
            for (String num : setList.get(i)) {
                if (!visited.contains(num)){
                    visited.add(num);
                    ans[i] = Integer.parseInt(num);
                    break;
                }
            }
        }
        return ans;
    }
}

'''


