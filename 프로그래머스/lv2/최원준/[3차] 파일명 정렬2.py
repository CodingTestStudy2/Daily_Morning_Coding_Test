# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;

class CustomFile {
    String head;
    String number;
    String tail;

    public CustomFile(String head, String number, String tail){
        this.head = head;
        this.number = number;
        this.tail = tail;
    }

    @Override
    public String toString() {
        return head + number + tail;
    }
}

class Leetcode.이재훈.Solution {
    public CustomFile split(String s) {
        int idx = 0;

        StringBuilder head = new StringBuilder();
        while (!Character.isDigit(s.charAt(idx))) head.append(s.charAt(idx++));

        StringBuilder number = new StringBuilder();
        while (idx < s.length() && Character.isDigit(s.charAt(idx))) number.append(s.charAt(idx++));

        StringBuilder tail = new StringBuilder();
        while (idx < s.length()) tail.append(s.charAt(idx++));

        return new CustomFile(head.toString(), number.toString(), tail.toString());
    }

    public String[] solution(String[] files) {
        ArrayList<CustomFile> customFileList = new ArrayList<>();

        for (String file : files) customFileList.add(split(file));

        customFileList.sort((a, b) -> {
            int headCompare = a.head.compareToIgnoreCase(b.head);
            if (headCompare != 0) return headCompare;

            int numberCompare = Integer.compare(Integer.parseInt(a.number), Integer.parseInt(b.number));
            return numberCompare;
        });

        String[] answer = new String[files.length];
        for (int i = 0; i < customFileList.size(); i++) {
            answer[i] = customFileList.get(i).toString();
        }
        return answer;
    }
}

'''


