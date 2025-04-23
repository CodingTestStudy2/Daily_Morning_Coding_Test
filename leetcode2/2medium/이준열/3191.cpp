class Solution {
    public:
        void flipTuple(int &a, int &b, int &c)
        {
            a = (a == 1) ? 0 : 1;
            b = (b == 1) ? 0 : 1;
            c = (c == 1) ? 0 : 1;
        }
    
    
        int minOperations(vector<int>& nums) {
            int minOp = 0;
    
            for (int i = 0; i < nums.size() -2;i++)
            {
                if (nums[i] == 0)
                {
                    minOp++;
                    flipTuple(nums[i], nums[i+1], nums[i+2]);
                }
            }
    
            if (nums[nums.size() - 3] != 1 ||
                nums[nums.size() - 2] != 1 ||
                nums[nums.size() - 1] != 1)
                return -1;
            return minOp;
        }
    };