#include <string>
#include <vector>
#include <cmath>

using namespace std;

int maxCubed[101];

int solution(vector<int> arr) {
    int answer = 1;
    
    for(int cnt = 0 ; cnt < arr.size() ; ++cnt)
    {
        vector<int> curCubed(101, 0);
    
        int num = arr[cnt];
        while(num != 1)
        {
            for(int mod = 2 ; mod <= num ; ++mod)
            {
                if(num % mod == 0)
                {
                    
                    
                    curCubed[mod]++;
                    num /= mod;
                    break;
                }
            }
            
        }
        
        for(int cubedIdx = 2; cubedIdx < 101 ; ++cubedIdx) maxCubed[cubedIdx] = max(maxCubed[cubedIdx], curCubed[cubedIdx]);
    }
    
    for(int num = 2; num < 101 ; ++num)
    {
        
        if(maxCubed[num] != 0)
        {
            answer *= pow(num, maxCubed[num]);
        }
    }
    
    return answer;
}

/*

최소공배수를 구하기 위해서 각각의 요소를 소인수 분해 하고, 종합할 때 지수가 더 커지는 것을 종합을 한다.

*/