#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int solution(int n) {
    int answer = 0;
    string s;
    while(n!=0)
    {
        s.push_back(n%3+'0');
        n=n/3;
    }
    
    
    return stoi(s,nullptr,3);
}
