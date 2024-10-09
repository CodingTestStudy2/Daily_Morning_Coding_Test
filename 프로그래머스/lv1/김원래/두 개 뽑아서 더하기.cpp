#include <string>
#include <vector>
#include <set>

using namespace std;

set<int> s;

vector<int> solution(vector<int> numbers) {
    vector<int> answer;
    
    for(int i = 0 ; i < numbers.size();  ++i) {
        for(int j = i + 1 ; j < numbers.size(); ++j) {
            s.insert(numbers[i] + numbers[j]);
        }
    }
    
    for(auto iter = s.begin() ; iter != s.end() ; ++iter) {
        answer.push_back(*iter);
    }
    
    return answer;
}

/*



*/