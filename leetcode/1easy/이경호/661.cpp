class Solution {
public:
  vector<vector<int>> imageSmoother(vector<vector<int>>& img) {
    vector<vector<int>> newImg(img.size(), vector<int>(img[0].size(), 0));
    for (int i = 0; i < img.size(); i++) {
      for (int j = 0; j < img[0].size(); j++) {
        int size = 0;
        int sum = 0;
        for (int ti = -1; ti <= 1; ti++) {
          for (int tj = -1; tj <= 1; tj++) {
            if (i + ti < 0 || i + ti >= img.size()
              || j + tj < 0 || j + tj >= img[0].size()) {
              continue;
            }
            sum += img[i + ti][j + tj];
            size++;
          }
        }
        newImg[i][j] = sum / size;
      }
    }
    return newImg;
  }
};