class Solution {
    public:
        int maxFrequencyElements(vector<int>& nums) {
            unordered_map<int, int> freqMap;
    
            for (int n : nums)
            {
                freqMap[n]++;
            }
    
            int maxFreq = 0;
            int cnt = 0;
            for (auto it = freqMap.begin(); it != freqMap.end(); it++)
            {
                if (maxFreq == it->second)
                {
                    cnt++;
                }
                else if (maxFreq < it->second)
                {
                    maxFreq = it->second;
                    cnt = 1;
                }
            }
    
            return maxFreq * cnt;
        }
    };