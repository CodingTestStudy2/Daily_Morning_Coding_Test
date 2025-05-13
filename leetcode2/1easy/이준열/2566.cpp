class Solution {
    public:
        int minMaxDifference(int num) {
            string conv = to_string(num);
            string minStr = conv;
            string maxStr = conv;
            char minWord = conv[0];
            char maxWord = -1;
            for (int i = 0; i < conv.size(); i++)
            {
                if (conv[i] == minWord)
                {
                    minStr[i] = '0';
                }
                if (maxWord == -1 && conv[i] != '9')
                {
                    maxWord = conv[i];
                    maxStr[i] = '9';
                }
                if (conv[i] == maxWord)
                {
                    maxStr[i] = '9';
                }
            }
            int minVal = stoi(minStr);
            int maxVal = stoi(maxStr);
    
            return maxVal - minVal;
        }
    };