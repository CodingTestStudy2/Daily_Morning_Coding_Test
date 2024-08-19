import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 체육복 잃어버린 학생
        Set<Integer> lSet = new TreeSet<>();

        for (int l : lost) {
            lSet.add(l);
        }

        // 체육복 빌려줄 수 있는 학생
        Set<Integer> rSet = new TreeSet<>();
        for (int r : reserve) {
            if(lSet.contains(r)) {
                lSet.remove(Integer.valueOf(r));
                continue;
            }
            rSet.add(r);
        }
        System.out.println(lSet.toString());


        // 도난 당한 학생 확인
        Set<Integer> filteredSet = lSet.stream().filter(l -> {
            if (rSet.contains(l-1)) {
                rSet.remove(Integer.valueOf(l-1));
                return false;
            }
            if (rSet.contains(l+1)) {
                rSet.remove(Integer.valueOf(l+1));
                return false;
            }

            return true;
        }).collect(Collectors.toSet());
        System.out.println(filteredSet.toString());


        int answer = n - filteredSet.size();

        return answer;
    }
}