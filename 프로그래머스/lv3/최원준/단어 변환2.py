# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''

'''
import java.util.*;
<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution {
=======
class Leetcode.이재훈.Solution {
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    int size;
    
    boolean check(String word1, String word2){
        int diff = 0;
        for (int i = 0; i<size; i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
                if (diff > 1){
                    return false;
                }
            }
        }
        return diff==1;
    }
    
    public int solution(String begin, String target, String[] words) {
        size = begin.length();
        
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        wordList.add(begin);
        
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        wordSet.add(begin);
        
        Set<String> visited = new HashSet<>();
        Map<String, List<String>> sMap = new HashMap<>();
        
        if (!wordSet.contains(target)) return 0;
        
        for (String word1: wordList) {
            sMap.put(word1, new ArrayList<>());
            for (String word2: wordList) {
                if (word1.equals(word2)) continue;
                if (check(word1, word2)) {
                    sMap.get(word1).add(word2);   
                }
            }
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.add(begin);
        visited.add(begin);
        int steps = 0;
        
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            
            for (int i=0; i<queueSize; i++){
                String curr = queue.poll();
                if (curr.equals(target)) {
                    return steps;
                }
                
                for (String candid : sMap.get(curr)) {
                    if (!visited.contains(candid)) {
                        queue.add(candid);
                        visited.add(candid);
                    }
                }
            }
            steps ++;
        }
        
        int answer = 0;
        return answer;
    }
}'''