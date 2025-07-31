public class Solution
{
    public int UnhappyFriends(int n, int[][] preferences, int[][] pairs)
    {
        int[] friends = new int[n];
        int[][] rank = new int[n][];

        foreach (var pair in pairs)
        {
            friends[pair[0]] = pair[1];
            friends[pair[1]] = pair[0];
        }

        for (int i = 0; i < n; i++)
        {
            rank[i] = new int[n];
            for (int j = 0; j < n-1; j++)
            {
                rank[i][preferences[i][j]] = j;
            }
        }

        int result = 0;

        for (int i = 0; i < n; i++)
        {
            int friend = friends[i];
            for (int j = 0; j < n - 1; j++)
            {
                int preferredFriend = preferences[i][j];
                if (rank[i][preferredFriend] < rank[i][friend])
                {
                    if (rank[preferredFriend][i] < rank[preferredFriend][friends[preferredFriend]])
                    { 
                        result++;

                        break;
                    }
                }
                else
                {
                    break;
                }
            }
        }

        return result;
    }
}