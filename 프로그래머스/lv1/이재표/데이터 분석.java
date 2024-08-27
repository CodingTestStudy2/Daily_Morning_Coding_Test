import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int ext_idx;
        if (ext.equals("date")) {
            ext_idx = 1;
        } else if (ext.equals("code")) {
            ext_idx = 0;
        } else if (ext.equals("maximum")) {
            ext_idx = 2;
        } else {
            ext_idx = 3;
        }
        
        int sort_idx;
        if (sort_by.equals("date")) {
            sort_idx = 1;
        } else if (sort_by.equals("code")) {
            sort_idx = 0;
        } else if (sort_by.equals("maximum")) {
            sort_idx= 2;
        } else {
            sort_idx= 3;
        }

        int[][] array = Arrays.stream(data)
            .filter(d -> d[ext_idx] < val_ext)
            .sorted(Comparator.comparing(d -> d[sort_idx]))
            .toArray(int[][]::new);
        return array;
    }
}
