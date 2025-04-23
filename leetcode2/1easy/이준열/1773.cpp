class Solution {
    public:
        int countMatches(vector<vector<string>>& items, string ruleKey, string ruleValue) {
            int output = 0;
            int checkIndex = 0;
            if (ruleKey == "type")
                checkIndex = 0;
            else if (ruleKey == "color")
                checkIndex = 1;
            else
                checkIndex = 2;
            for (vector<string> v: items)
            {
                if (v[checkIndex] == ruleValue)
                    output++;
            }
            return output;
        }
    };