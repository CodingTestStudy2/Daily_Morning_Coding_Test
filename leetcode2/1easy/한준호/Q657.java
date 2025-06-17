package Leetcode.한준호;

class Solution {
    public boolean judgeCircle(String moves) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<moves.length(); i++){
            map.merge(moves.charAt(i), 1, Integer::sum);
        }
        int up = map.getOrDefault('U',0);
        int down = map.getOrDefault('D',0);
        int left = map.getOrDefault('L',0);
        int right = map.getOrDefault('R',0);
        return up==down && left==right;
    }
}