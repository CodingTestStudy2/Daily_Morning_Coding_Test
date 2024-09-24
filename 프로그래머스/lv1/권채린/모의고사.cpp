#include <string>
#include <vector>
#include <algorithm>
// 12345 5의배수
// 21232425 8배수
// 3311224455 10의 배수

using namespace std;
int hit1,hit2,hit3;
vector<int> solution(vector<int> answers) {
    vector<int> answer;
    vector<int> one = {1,2,3,4,5};
    vector<int> two = {2,1,2,3,2,4,2,5};
    vector<int> three = {3,3,1,1,2,2,4,4,5,5};
    
    for(int i=0; i<answers.size(); i++) {
        if(answers[i]==one[i%5])
            hit1++;
        if(answers[i]==two[i%8])
            hit2++;
        if(answers[i]==three[i%10])
            hit3++;
    }
    int maxhit = max({hit1,hit2,hit3});
    
    if(maxhit==hit1){answer.push_back(1);}
    if(maxhit==hit2){answer.push_back(2);}
    if(maxhit==hit3){answer.push_back(3);}
   
    
    return answer;
}
