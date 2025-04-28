class Solution {
    public:
        bool kLengthApart(vector<int>& nums, int k) {
            int zeroCount = 0;
            int oneIndex = -1;
            for (int i = 0;  i < nums.size(); i++)
            {
                if (nums[i] == 1)
                {
                    if (oneIndex == -1)
                    {
                        oneIndex = 0;
                    }
                    else
                    {
                        if (zeroCount < k)
                            return false;
                    }
                    zeroCount = 0;
                }
                else if (nums[i] == 0)
                {
                    zeroCount++;
                }
            }
            return true;
        }
    };