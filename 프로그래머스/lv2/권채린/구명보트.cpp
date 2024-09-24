#include <string>
#include <vector>
#include <algorithm>
// 최대 2명이 탈 수 있으며, 몸무게 최댓값 보다는 무조건 크다 => 가장 무거운 사람을 태우고, 가장 가벼운 사람을 추가로 태울 수 있을 지 체크
using namespace std;

int solution(vector<int> people, int limit) {
    int answer = 0;
    sort(people.begin(), people.end());
  
    int start=0;
    int end=people.size()-1;
  
    while(start<=end) {
        if(people[start]+people[end]<=limit)
            start++;
        end--;
        answer++;
    }

    return answer;
}
