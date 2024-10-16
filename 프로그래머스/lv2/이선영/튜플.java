import java.util.*;

class Solution {
    public int[] solution(String s) {
        // 입력에서 바깥 중괄호 제거
        s = s.substring(2, s.length() - 2);
        // System.out.println(s);
        
        // 각 집합을 문자열로 분리 (중괄호 기준으로)
        String[] arr = s.split("\\},\\{");
        
        // 각 집합을 정렬하기 위해 리스트로 변환
        List<int[]> list = new ArrayList<>();

        for (String set : arr) {
            // 숫자만 남기고 배열로 변환
            set = set.replace("{", "").replace("}", "");
            String[] nums = set.split(",");
            int[] numArray = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {
                numArray[i] = Integer.parseInt(nums[i]);
            }
            
            list.add(numArray);
        }

        // 집합을 크기 순으로 정렬
        Collections.sort(list, (o1,o2)-> o1.length-o2.length);
        
        // 결과 리스트에 중복 없이 숫자 추가
        List<Integer> resultList = new ArrayList<>();
        boolean[] seen = new boolean[100_101];

        for (int[] numArray : list) {
            for (int num : numArray) {
                if (!seen[num]) {
                    resultList.add(num);
                    seen[num] = true;
                }
            }
        }

        // 결과 리스트를 배열로 변환
        int[] answer = new int[resultList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = resultList.get(i);
        }

        return answer;
    }
}
