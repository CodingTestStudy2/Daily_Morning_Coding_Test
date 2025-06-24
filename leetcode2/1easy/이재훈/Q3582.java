package Leetcode.이재훈;

/*
1. 아이디어 :

- caption의 앞 뒤 트림을 지우고 스페이스를 기준으로 배열로 만든다.
- "#"를 가진 stringbuilder를 가지고 i==0 일때만 첫 알파뱃이 lowercase고
- i!= 0 이 아닐때는 첫 알파뱃이 Uppercase 그 후 알파뱃은 lowercase로 변경하여 Stringbuilder에 저장한다.
- sb에 저장되어있는 스트링의 길이가 100이 넘으면 100으로 짤르고 for문을 탈출한다.

2. 시간복잡도 :
O( n )
3. 자료구조/알고리즘 :
- /
 */

public class Q3582 {
    class Solution {
        public String generateTag(String caption) {

            String[] arr = caption.trim().split(" ");
            StringBuilder sb = new StringBuilder();
            sb.append("#");
            for(int i = 0; i < arr.length; i++) {
                if(arr[i].trim().length() == 0) continue;
                if(i == 0) sb.append(Character.toLowerCase(arr[i].charAt(0))).append(arr[i].substring(1).toLowerCase());
                else sb.append(Character.toUpperCase(arr[i].charAt(0))).append(arr[i].substring(1).toLowerCase());

                if(sb.length() > 100) {
                    sb.setLength(100);
                    break;
                }
            }

            return sb.toString();
        }
    }
}