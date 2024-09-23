import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        String[] s = map.keySet().toArray(new String[0]);
        Arrays.sort(s, (a, b) -> map.get(b) - map.get(a));
        
        List<Integer> answer = new ArrayList<>();
        
        for (String genre : s) {
            List<int[]> arr = new ArrayList<>();

            for (int genreIdx = 0; genreIdx < genres.length; genreIdx++) {
                if (genres[genreIdx].equals(genre)) {
                    arr.add(new int[]{genreIdx, plays[genreIdx]});
                }
            }

            Collections.sort(arr, (o1, o2) -> {
                if (o2[1] == o1[1]) {
                    return o1[0] - o2[0];
                }
                return o2[1] - o1[1];
            });

            for (int j = 0; j < Math.min(2, arr.size()); j++) {
                answer.add(arr.get(j)[0]);
            }
        }

         int[] result = new int[answer.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
}
