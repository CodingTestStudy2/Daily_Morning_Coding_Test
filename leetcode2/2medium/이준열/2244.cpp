class Solution {
    public:
        int minimumRounds(vector<int>& tasks) {
            map<int, int>taskCount; //key: lev, value: cnt
            int output = 0;
    
            for (int t: tasks)
                taskCount[t]++;
            
            for (auto pair: taskCount)
            {
                vector<int>v(3, 214743648);
                int last = 0;
                int minCnt = 214743648;
                int cnt = pair.second;
                if (cnt == 1)
                    return -1;
                if (cnt % 3 == 0)
                {
                    v[0] = min(v[0], cnt / 3);
                }
                if (cnt % 2 == 0)
                {
                    v[1] = min(v[1], cnt / 2);
                }
    
                // last resort
                int f = cnt;
                int s = cnt;
                int threeCnt = cnt / 3;
                int oneRes = 214743648;
                int twoRes = 214743648;
                // one. just do it
                f -= 3 * threeCnt;
                if (f % 2 == 0)
                {
                    oneRes = threeCnt + f /2;
                }
                // two. substract one and then calculate
                s -= 3 * (threeCnt -1);
                if (s % 2 == 0)
                {
                    twoRes = threeCnt - 1 + s / 2;
                }
                v[2] = min (oneRes, twoRes);
                for (int i = 0; i < 3; i++)
                {
                    minCnt = min(minCnt, v[i]);
                }
                if (minCnt == 214743648)
                    return -1;
                else
                    output += minCnt;
            }
            return output;
    
            
        }
    };