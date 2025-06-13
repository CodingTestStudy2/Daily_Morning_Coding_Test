class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int max = 0;
        int degree[] = new int[n];
        boolean connected[][] = new boolean[n][n];

        for(int road[] : roads){
            int a = road[0];
            int b = road[1];
            degree[a]++;
            degree[b]++;
            connected[a][b] = true;
            connected[b][a] = true;
        }

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int rank = degree[i] + degree[j];
                if(connected[i][j]) rank -= 1;
                max = Math.max(max, rank);
            }
        }

        return max;
    }
}
