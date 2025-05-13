package Leetcode;

/*
1. 아이디어 :

- words에서 각 word들을 가지고 s 에 있는 데이터에 포함됬는지 확인
- word의 각각 char을 뽑아내어 s에서의 인덱스를 찾아가지고 그 전 char의 인덱스보다 클경우에만 진행하여 word의 길이만큼 잘 돌면 포함
- 그 전 char의 인덱스 보다 작거나 같을경우에는 count를 증가하지 않는다.
- count를 값으로 반환

2. 시간복잡도 :
O( 2n)
3. 자료구조/알고리즘 :
- /
 */

public class Q792 {
    class Solution {
        public int numMatchingSubseq(String s, String[] words) {

            int count = 0;
            for(String word : words) {
                boolean isFlag = true;
                int preIdx = -1;

                for(int i = 0; i<word.length(); i++) {

                    int idx = s.indexOf(word.charAt(i), preIdx +1);

                    // System.out.println("word : " + word + " word.charAt() : " + word.charAt(i) + " idx : " + idx + " preIdx : " + preIdx);

                    if(idx <= preIdx) {
                        isFlag = false;
                        break;
                    }

                    preIdx = idx;

                }
                if(isFlag) count++;
            }
            return count;
        }
    }
}