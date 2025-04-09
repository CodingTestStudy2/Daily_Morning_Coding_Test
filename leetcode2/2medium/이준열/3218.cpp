class Solution {
    public:
        int minimumCost(int m, int n, vector<int>& horizontalCut, vector<int>& verticalCut) {
            int hWeight = 1;
            int vWeight = 1;
            std::priority_queue<int> horizontal;
            std::priority_queue<int> vertical;
            int output = 0;
    
            for (int i : horizontalCut)
                horizontal.push(i);
            for (int j : verticalCut)
                vertical.push(j);
    
            while ((horizontal.size() != 0) && (vertical.size() != 0))
            {
                if (horizontal.top() > vertical.top())
                {
                    output += horizontal.top() * vWeight;
                    horizontal.pop();
                    hWeight++;
                }
                else if (horizontal.top() < vertical.top())
                {
                    output += vertical.top() * hWeight;
                    vertical.pop();
                    vWeight++;
                }
                else
                {
                    output += horizontal.top() * vWeight;
                    horizontal.pop();
                    hWeight++;
                }
            }
            if (horizontal.size() == 0)
            {
                while(vertical.size() != 0)
                {
                    output += vertical.top() * hWeight;
                    vertical.pop();
                }
            }
            if (vertical.size() == 0)
            {
                while (horizontal.size() != 0)
                {
                    output += horizontal.top() * vWeight;
                    horizontal.pop();
                }
            }
    
    
            return output;
        }
    };