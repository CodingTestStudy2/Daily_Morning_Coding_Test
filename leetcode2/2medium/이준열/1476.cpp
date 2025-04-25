class SubrectangleQueries {
    public:
        SubrectangleQueries(vector<vector<int>>& rectangle) {
            rectangleVal = rectangle;
            
        }
        
        void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            for (int i = row1; i <= row2; i++)
            {
                for (int j = col1; j <= col2; j++)
                {
                    rectangleVal[i][j] = newValue;
                }
            }
            
        }
        
        int getValue(int row, int col) {
            return rectangleVal[row][col];
        }
    private:
        vector<vector<int>> rectangleVal;
    };