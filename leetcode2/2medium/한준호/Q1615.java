package 한준호;

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[][] adjMatrix = new int[n][n];
        for (int i = 0; i<roads.length; i++){
            adjMatrix[roads[i][0]][roads[i][1]] = 1;
            adjMatrix[roads[i][1]][roads[i][0]] = 1;
        }
        int ans = 0;
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                ans = Math.max(ans, calc(i, j, adjMatrix));
            }
        }
        return ans;
    }

    public int calc(int node1, int node2, int[][] adjMatrix){
        int result = 0;
        for(int i = 0; i<adjMatrix.length; i++){
            result += adjMatrix[node1][i];
        }

        for(int i = 0; i<adjMatrix.length; i++){
            result += adjMatrix[node2][i];
        }

        if(adjMatrix[node1][node2] == 1) result--;
        return result;
    }


}