#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(int k, int m, vector<int> score) {
    int answer = 0;
    
    sort(score.begin(), score.end());
    reverse(score.begin(), score.end());
    
    for(int cnt = 0 ; cnt + m-1 < score.size() ; cnt += m)
    {
       
        int p = score[cnt + m - 1];
        int value = p * m;
        
        answer += value;

    }
    
    return answer;
}

/*

score 배열이 주어진다. (1 ~ k 요소)

m개씩 한 상자에 사과를 담는다.
상자 하나의 값어치는 상자에 담은 최소 점수 * m

scores를 오름차순 sort를 하고,
폴링을 도는데, m을 기준으로 polling을 한다.

*/