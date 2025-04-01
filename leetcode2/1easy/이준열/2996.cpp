class Solution {
    public:
        int missingInteger(vector<int>& nums) {
            int p = nums[0];
            int cnt = 1;
            int lsp = nums[0];
    
            for (int j = 1; j < nums.size(); j++)
            {
                if (nums[j] == nums[j-1] + 1)
                    lsp += nums[j];
                else
                    break;
            }
    
            int output = lsp;
    
            vector<int> sorted = nums;
            sort(sorted.begin(), sorted.end());
    
    
            for (int j = 0; j < sorted.size(); j++)
            {
                if (sorted[j] == output)
                {
                    output++;
                }
            }
    
            return output;
        }
    };