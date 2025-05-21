class Solution {
public:
    int maxRectangleArea(vector<vector<int>>& points) {
        int output = -1;
        set<pair<int,int>> pointSet;

        for (vector<int> p : points)
        {
            pointSet.insert(make_pair(p[0], p[1]));
        }

        int s = points.size();

        for (int i = 0; i < s; i++)
        {
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = i + 1; j < s; j++)
            {
                int x2 = points[j][0], y2 = points[j][1];

                if (x1 == x2 || y1 == y2) continue;

                if (pointSet.count({x1,y2}) && pointSet.count({x2, y1}))
                {
                    int left = min(x1, x2), right  = max(x1,x2);
                    int top = max(y1, y2), bottom = min(y1, y2);
                    bool valid  = true;

                    for (vector<int> p: points)
                    {
                        int x = p[0], y = p[1];
                        if ((x == x1 && y == y1) || (x == x2 && y == y2)
                            || (x == x2 && y == y1) || (x == x1 && y == y2))
                            continue;

                        if (x >= left && x <= right && y >= bottom && y <= top)
                        {
                            valid = false;
                            break;
                        }
                    }

                    if (valid)
                    {
                        int vol = (right - left) * (top - bottom);
                        output = max(vol, output);
                    }
                }
            }
        }

        return output;
    }
};