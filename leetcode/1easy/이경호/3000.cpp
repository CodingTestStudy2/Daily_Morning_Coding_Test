class Solution {
  public:
      int areaOfMaxDiagonal(vector<vector<int>>& dimensions) {
          vector<vector<double>> newD(dimensions.size(), vector<double>(2));
          for(auto& dimension : dimensions) {
              double diagonal = sqrt(pow(dimension[0], 2) + pow(dimension[1], 2));
              double area = dimension[0] * dimension[1];
              newD.push_back({diagonal, area});
          }
          sort(newD.begin(), newD.end());
          return newD.back()[1];
      }
  };