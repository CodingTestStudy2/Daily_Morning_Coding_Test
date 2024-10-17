#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(vector<int>& a, vector<int>& b) // 0을 기준 내림차순
{
    if(a[0] == b[0])
        return a[1] < b[1];
    
    return a[0] > b[0];
}

bool compare2(vector<int>& a, vector<int>& b) // 1을 기준 내림차순
{
    if(a[1] == b[1])
        return a[0] < b[0];
    
    return a[1] > b[1];
}

int solution(vector<vector<int>> sizes) {
    int answer = 0;
    
    sort(sizes.begin(),sizes.end(), compare);
    
    int maxWidth = sizes[0][0];
    int minHeight = sizes[0][1];


    for(vector<int>& size : sizes) {
        if(size[1] > minHeight) {
            if(size[1] > maxWidth) {
                minHeight = size[1];   
            }
            else {
                minHeight = max(minHeight, size[0]);
            }
        }
    }
    
    sort(sizes.begin(), sizes.end(), compare2);
    
    int maxHeight = sizes[0][1];
    int minWidth = sizes[0][0];
    
    for(vector<int>& size : sizes) {
        if(size[0] > minWidth) {
            if(size[0] > maxHeight) {
                minWidth = size[0];   
            }
            else {
                minWidth = max(minWidth, size[1]);
            }
        }
    }
    
    answer = min(maxWidth * minHeight, maxHeight * minWidth);
    
    return answer;
}