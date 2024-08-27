#include <iostream>
#include <string> 
#include <cstring>
#include <sstream>
#include <algorithm>
#include <vector>
#include <cmath>
#include <stack>
#include <queue>
#include <deque>
#include <map>
#include <set>
#include <unordered_set>
#include <unordered_map>
using namespace std;
typedef long long ll;
typedef pair<int, int> pii;

int calcDist(pii a, pii b){
    return abs(a.first - b.first) + abs(a.second - b.second);
}

string solution(vector<int> numbers, string hand) {
    string ans = "";
    pair<pii, pii> pos = {{3, 0}, {3, 2}};
    
    for(int num: numbers){
        if(num == 0) num = 11;
        
        if(num % 3 == 1){
            ans += "L";
            pos.first = {num/3, 0};
        }else if(num % 3 == 0){
            ans += "R";
            pos.second = {num/3 - 1, 2};
        }else{
            pii next = {num/3, 1};
            int leftDist = calcDist(pos.first, next);
            int rightDist = calcDist(pos.second, next);
            
            if(leftDist < rightDist){
                ans += "L";
                pos.first = next;
            }else if(leftDist > rightDist){
                ans += "R";
                pos.second = next;
            }else{
                if(hand == "left"){
                    ans += "L";
                    pos.first = next;
                }else{
                    ans += "R";
                    pos.second = next;
                }
            }
        }
    }
    
    return ans;
}