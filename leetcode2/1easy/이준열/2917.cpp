class Solution {
    public:
        int findKOr(vector<int>& nums, int k) {
            // 2147 4836 47
            vector<int> bitSet(32, 0);
            for (int n : nums)
            {
                std::bitset<32> binary(n);
                string binaryStr = binary.to_string();
                for (int i = 0; i < binary.size(); i++)
                {
                    if (binaryStr[i] == '1')
                    {
                        bitSet[i]++;
                    }
                }
            }
            string str = "";
            for (int c: bitSet)
            {
                if (c >= k)
                {
                    str += '1';
                }
                else
                {
                    str += '0';
                }
            }
            return std::stoi(str, nullptr, 2);
        }
    };