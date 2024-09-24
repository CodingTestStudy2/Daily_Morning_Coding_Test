#include <string>
#include <vector>
#include <algorithm>

using namespace std;

// 반복되는 것을 배열로
constexpr int student1Size = 5;
constexpr int student2Size = 8;
constexpr int student3Size = 10;

int student1[student1Size] = { 1, 2, 3, 4, 5};
int student2[student2Size] = { 2, 1, 2, 3, 2, 4, 2, 5};
int student3[student3Size] = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    
    int res[3] = {0, 0, 0};

    for(int cnt = 0 ; cnt < answers.size() ; ++cnt)
    {
        if(answers[cnt] == student1[cnt % student1Size]) ++res[0];
        if(answers[cnt] == student2[cnt % student2Size]) ++res[1];
        if(answers[cnt] == student3[cnt % student3Size]) ++res[2];   
    }
    
    answer.push_back(1);
    if(res[0] < res[1]) answer[0] = 2;
    else if(res[0] == res[1]) answer.push_back(2);
    
    if(res[answer[0] - 1] < res[2]) answer[0] = 3;
    else if(res[answer[0] - 1] == res[2]) answer.push_back(3);
    
    return answer;
}


/*



*/