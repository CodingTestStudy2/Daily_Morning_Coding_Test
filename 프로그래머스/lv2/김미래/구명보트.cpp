#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

int solution(vector<int> people, int limit) {
    int answer = 0;
    vector<bool> check(people.size(), false);
    sort(people.begin(), people.end(), greater<>());
    
    int start = 0;
    int end = people.size() -1 ;
    
    while(start<= end){
        if(people[start] + people[end] <= limit){
            end--;
        }
        start++;
        answer++;

    }
    
    return answer;
}
