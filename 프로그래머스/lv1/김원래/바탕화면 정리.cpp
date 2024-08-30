#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> wallpaper) {
    vector<int> answer;
    
    int x1 = 100;
    int x2 = -1;
    
    int y1 = 100;
    int y2 = -1;
    
    for(int row = 0 ; row < wallpaper.size() ; ++row)
    {
        for(int col = 0 ; col < wallpaper[row].size() ; ++col)
        {
            if(wallpaper[row][col] == '#')
            {

                
                x1 = min(x1, col);
                x2 = max(x2, col);
                
                y1 = min(y1, row);
                y2 = max(y2, row);
                
                //printf("row : %d / col : %d / val : %c / x1 : %d / y1 : %d / x2 : %d / y2 : %d\n", row, col, wallpaper[row][col], x1, y1, x2, y2);
            }
        }
    }
    
    answer.push_back(y1);
    answer.push_back(x1);
    answer.push_back(y2 + 1);
    answer.push_back(x2 + 1);
    
    return answer;
}