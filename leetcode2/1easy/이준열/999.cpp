class Solution {
    public:
        int dirs[4][2] = {{1, 0}, {-1,0}, {0,1}, {0,-1}};
        
    
        int numRookCaptures(vector<vector<char>>& board) {
            pair<int, int> RookLoc;
    
            for (int i = 0 ; i < 8; i++)
            {
                for (int j = 0; j < 8; j++)
                {
                    if (board[i][j] == 'R')
                        RookLoc = make_pair(i, j);
                }
            }
    
            int output = 0;
    
            for (int d = 0; d < 4; d++)
            {
                int m = RookLoc.first;
                int n = RookLoc.second;
    
                while (((m >= 0) && (m < 8)) &&
                        ((n >= 0) && (n < 8)))
                {
                    if (board[m][n] == 'B')
                        break;
                    if (board[m][n] == 'p')
                    {
                        output++;
                        break;
                    }
                    m += dirs[d][0];
                    n += dirs[d][1];
                }
            }
    
            return output;
            
        }
    };