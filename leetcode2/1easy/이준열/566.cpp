class Solution {
    public:
        vector<vector<int>> matrixReshape(vector<vector<int>>& mat, int r, int c) {
            vector<vector<int>> output;
            int currentRow = mat.size();
            int currentColumn = mat[0].size();
            int index = 0;
    
            if (currentRow * currentColumn != r * c)
                return mat;
    
            for (int row = 0; row < r;row++)
            {
                vector<int> tmp(c);
                for (int column = 0; column < c; column++)
                {
                    tmp[column] = mat[index / currentColumn][index % currentColumn];
                    index++;
                }
                output.push_back(tmp);
            }
            return output;
        }
    };