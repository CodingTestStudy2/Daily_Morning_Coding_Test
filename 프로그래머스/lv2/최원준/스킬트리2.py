# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    각 스킬트리에서 스킬을 차례대로 검사하면서 스킬트리가 가능한지 확인
2. 시간복잡도 :
    O(26 * 26)
3. 자료구조 :
    해시맵

import java.util.*;
class Solution {
    Map<Character, Integer> skillIdxs = new HashMap<>();

    public boolean check(String skill, String skillTree) {
        int skill_idx = 0;
        for (int i = 0; i<skillTree.length(); i++) {
            char currSkill = skill.charAt(skill_idx), currSkillTree = skillTree.charAt(i);
            if (!skillIdxs.containsKey(currSkillTree)) continue;
            if (skillIdxs.get(currSkillTree) != skill_idx) return false;
            skill_idx += 1;
            if (skill_idx == skill.length()) return true;
        }
        return true;
    }
    public int solution(String skill, String[] skill_trees) {
        int ans = 0;
        for (int i = 0; i<skill.length(); i++) skillIdxs.put(skill.charAt(i), i);
        for (String skillTree : skill_trees) if (check(skill, skillTree)) ans++;
        return ans;
    }
}
'''


