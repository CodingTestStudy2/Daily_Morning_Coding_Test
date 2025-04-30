class Solution {
    public:
        int captureForts(vector<int>& forts) {
                int output = 0;
    
            for (int i = 0; i < forts.size(); i++)
            {
                if (forts[i] == 1)
                {
                    int left = i - 1;
                    int right = i + 1;
    
                    int leftCnt = 0;
                    int rightCnt = 0;
    
                    int maxLeft = 0;
                    int maxRight = 0;
    
                    bool metEmptyLeft = false; // meeting -1, 1 or end is wrong
                    bool metEmptyRight = false;
    
                    while (left >= 0)
                    {
                        if (forts[left] == 0)
                        {
                            leftCnt++;
                        }
                        else if (forts[left] == 1)
                        {
                            break;
                        }
                        else
                        {
                            maxLeft = max(maxLeft, leftCnt);
                            metEmptyLeft = true;
                            break;
                        }
                        left--;
                    }
                    if (metEmptyLeft)
                        output = max(output, maxLeft);
                    while (right <= forts.size()-1)
                    {
                        if (forts[right] == 0)
                        {
                            rightCnt++;
                        }
                        else if (forts[right] == 1)
                        {
                            break;
                        }
                        else
                        {
                            maxRight = max(maxRight, rightCnt);
                            metEmptyRight = true;
                            break;
                        }
                        right++;
                    }
                    if (metEmptyRight)
                        output = max(output, maxRight);
                }
            }
            
            return output;
        }
    };