class Solution {
    public:
    
        bool isPrefixAndSuffix(string str1, string str2)
        {
            if (str1.size() > str2.size())
                return false;
    
            auto fit = str1.begin();
            auto bit = str1.rbegin();
    
            auto str2front = str2.begin();
            auto str2back = str2.rbegin();
    
            for (; fit != str1.end(); fit++)
            {
                if (*fit != *str2front)
                    return false;
                str2front++;
            }
    
            for (; bit != str1.rend(); bit++)
            {
                if (*bit != *str2back)
                    return false;
                str2back++;
            }
    
            return true;
        }
    
        int countPrefixSuffixPairs(vector<string>& words) {
            int cnt = 0;
            int wordsCnt = words.size();
    
            for (int i = 0; i < wordsCnt - 1; i++)
            {
                for (int j = i + 1; j < wordsCnt; j++)
                {
                    if (isPrefixAndSuffix(words[i], words[j]))
                        cnt++;
                }
            }
            
            return cnt;
        }
    };