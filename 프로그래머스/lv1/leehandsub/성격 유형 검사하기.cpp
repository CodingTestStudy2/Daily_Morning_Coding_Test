#include <string>
#include <vector>

using namespace std;

int al[30];

string solution(vector<string> survey, vector<int> choices) {
    string answer = "";
    string temp;
    for(int i=0;i<survey.size();i++)
    {
        if(choices[i]<4)
        {
            al[survey[i][0]-'A']+=(4-choices[i]);
        }
        else
        {
            al[survey[i][1]-'A']+=(choices[i]-4);
        }
    }
    if(al['R'-'A']<al['T'-'A'])
        temp="T";
    else
        temp="R";
    if(al['C'-'A']<al['F'-'A'])
        temp.push_back('F');
    else
        temp.push_back('C');
    if(al['J'-'A']<al['M'-'A'])
        temp.push_back('M');
    else
        temp.push_back('J');
    if(al['A'-'A']<al['N'-'A'])
        temp.push_back('N');
    else
        temp.push_back('A');
    
    return temp;
}



