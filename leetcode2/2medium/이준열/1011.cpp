class Solution {
    public:
        bool canBeShipped(const vector<int>&weights, int days, int capacity)
        {
            int dayCnt = 1;
            int currentLoad = 0;
    
            for (int n : weights)
            {
                if (currentLoad + n > capacity)
                {
                    dayCnt++;
                    currentLoad = 0;
                }
                currentLoad += n;
            }
            return dayCnt <= days;
        }
    
    
        int shipWithinDays(vector<int>& weights, int days) {
            int left = *max_element(weights.begin(), weights.end());
            int right = accumulate(weights.begin(), weights.end(), 0);
    
            while (left < right)
            {
                int mid = left + (right - left) / 2;
                if (canBeShipped(weights, days, mid)) // enough to load: dimish capacity
                {
                    right = mid;
                }
                else // not enough to load: increment capacity
                {
                    left = mid + 1;
                }
            }
            return left;
            
        }
    };