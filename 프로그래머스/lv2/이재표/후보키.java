import java.util.*;

class Solution {
    List<int[]> list;
    String[][] relation;
    int colSize;
    int rowSize;
    List<List<Integer>> candidateKeys = new ArrayList<>();
    int answer = 0;

    public int solution(String[][] relations) {
        relation = relations;
        colSize = relation[0].length; // 열의 수
        rowSize = relation.length; // 행의 수
        int[] cols = new int[colSize];
        for (int i = 0; i < colSize; i++) {
            cols[i] = i;
        }

        for (int i = 1; i <= colSize; i++) {
            list = new ArrayList<>(); // i개수만큼씩 조합을 만들었을때 형태 들어가있음
            boolean[] visited = new boolean[colSize];
            comb1(cols, visited, 0, i);
            for (int[] l : list) {
                if (isMinimal(l)) {
                    find(l);
                }
            }
        }
        return answer;
    }

    void find(int[] lists) {
        Set<String> set = new HashSet<>();
        for (int r = 0; r < rowSize; r++) { // 각 행을 확인해야 하므로 rowSize 사용
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < lists.length; i++) {
                sb.append("/"+relation[r][lists[i]]); // relation[r][lists[i]] 사용
            }
            set.add(sb.toString());
        }

        if (set.size() == rowSize) { // 유일성 확인: 집합 크기와 행 크기가 같다면 유일
            answer++;
            List<Integer> key = new ArrayList<>();
            for (int i : lists) {
                key.add(i);
            }
            candidateKeys.add(key);
        }
    }

    boolean isMinimal(int[] lists) {
        List<Integer> listToCheck = new ArrayList<>();
        for (int l : lists) {
            listToCheck.add(l);
        }

        for (List<Integer> key : candidateKeys) {
            if (listToCheck.containsAll(key)) {
                return false;
            }
        }
        return true;
    }

    void comb1(int[] arr, boolean[] visited, int start, int r) {
        if (r == 0) {
            int cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) {
                    cnt++;
                }
            }
            int[] s = new int[cnt];
            int idx = 0;
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) {
                    s[idx++] = arr[i];
                }
            }
            list.add(s);
            return;
        } else {
            for (int i = start; i < arr.length; i++) {
                visited[i] = true;
                comb1(arr, visited, i + 1, r - 1);
                visited[i] = false;
            }
        }
    }
}
