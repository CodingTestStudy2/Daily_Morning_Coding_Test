public class LC_1893 {
    public boolean isCovered(int[][] ranges, int left, int right) {
        boolean[] visited = new boolean[51];
        for(int i=0; i<ranges.length; i++){
            for(int j=ranges[i][0]; j<=ranges[i][ranges[i].length-1]; j++){
                visited[j] = true;
            }
        }
        for(int i=left; i<=right; i++){
            if(!visited[i]) return false;
        }
        return true;
    }
}