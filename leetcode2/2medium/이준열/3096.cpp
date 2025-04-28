class Solution {
    public:
        int minimumLevels(vector<int>& possible) {
            vector<int> prefixSum(possible.size());
            prefixSum[0] = (possible[0] == 0) ? -1 : 1;
            int totalSum;
    
            for (int i = 1; i < possible.size(); i++)
            {
                int point = (possible[i] == 0) ? -1 : 1;
                prefixSum[i] =  prefixSum[i-1] + point;
            }
            totalSum = prefixSum[possible.size()-1];
    
            for (int j = 0; j < prefixSum.size()-1; j++)
            {
                if (prefixSum[j] > (totalSum - prefixSum[j]))
                    return j + 1;
            }
            return -1;
        }
    
        // possible[i] == 0 -> always fail
        // player clear +1 / fail -1
        // Alice plays first till K level
        // Bob plays rest of the games
    };