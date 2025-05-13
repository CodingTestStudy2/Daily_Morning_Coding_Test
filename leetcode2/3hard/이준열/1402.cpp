class Solution {
public:
    int maxSatisfaction(vector<int>& satisfaction) {
        long long output = 0;
        sort(satisfaction.begin(), satisfaction.end());
        vector<int> times(satisfaction.size());
        iota(times.begin(), times.end(), 1);
        for (int t : times)
            cout << t << ' ';

        for (int i = 0; i < satisfaction.size(); i++)
        {
            long long tmpSum = 0;
            for (int j = i, m = 0; j < satisfaction.size(); j++, m++)
            {
                tmpSum += times[m] * satisfaction[j]; 
            }
            output = (output < tmpSum) ? tmpSum : output;
        }

        return static_cast<int>(output);
    }
};