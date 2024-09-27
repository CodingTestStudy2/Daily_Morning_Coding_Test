#include <vector>
#include <unordered_set>

using namespace std;

int solution(vector<int> nums)
{
    int answer = 0;
    
    unordered_set<int> _set;
    
    for(int cnt = 0 ; cnt < nums.size() ; ++cnt)
    {
        _set.insert(nums[cnt]);
    }
    
    if(nums.size() / 2 <= _set.size()) answer = nums.size() / 2;
    else answer = _set.size();
    
    return answer;
}


/*

n/2개 선택


*/