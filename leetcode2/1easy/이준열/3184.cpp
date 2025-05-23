class Solution {
public:
    int countCompleteDayPairs(vector<int>& hours) {
        int output = 0;
        for (int i = 0; i < hours.size(); i++)
        {
            for (int j = i + 1; j < hours.size(); j++)
            {
                if((static_cast<long long>(hours[i]) + static_cast<long long>(hours[j])) % 24 == 0)
                    output++;
            }
        }
        return output;
    }
};