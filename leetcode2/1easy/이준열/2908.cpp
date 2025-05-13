class Solution {
    public:
        int minimumSum(vector<int>& nums) {
            int output = 153;
            for (int j = 1; j < nums.size() - 1; j++)
            {
                int left = 51;
                int right = 51;
    
                for (int i = j - 1; i >= 0; i--)
                {
                    if (nums[j] > nums[i])
                    {
                        left = min(left, nums[i]);
                    }
                }
                for (int k = j + 1; k < nums.size(); k++)
                {
                    if (nums[j] > nums[k])
                    {
                        right = min(right, nums[k]);
                    }
                }
                if (left != 51 && right != 51)
                    output = min(output, nums[j] + left + right);
            }
            if (output == 153)
                return -1;
            return output;
        }
    };