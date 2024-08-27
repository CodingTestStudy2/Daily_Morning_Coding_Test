#include <iostream>
#include <string> 
#include <cstring>
#include <sstream>
#include <algorithm>
#include <vector>
#include <cmath>
#include <stack>
#include <queue>
#include <map>
#include <set>
#include <unordered_set>
#include <unordered_map>
using namespace std;
typedef long long ll;
typedef pair<int, int> pii;

string g_ext;
int valExt;
string sortBy;

struct Data {
    int code;
    int date;
    int maximum;
    int remain;
};

vector<vector<int>> answer;
vector<Data> v;

bool compare(Data& a, Data& b){
    if(sortBy == "code"){
        return a.code < b.code;
    }else if(sortBy == "date"){
        return a.date < b.date;
    }else if(sortBy == "maximum"){
        return a.maximum < b.maximum;
    }else{
        return a.remain < b.remain;
    }
}

void removeIfLagerThanExt(){
    function<bool(const Data&)> condition;
    if(g_ext == "code"){        
        condition = [](const Data& obj) {
            return obj.code >= valExt;
        };
    }else if(g_ext == "date"){
        condition = [](const Data& obj) {
            return obj.date >= valExt;
        };
    }else if(g_ext == "maximum"){
        condition = [](const Data& obj) {
            return obj.maximum >= valExt;
        };
    }else{
        condition = [](const Data& obj) {
            return obj.remain >= valExt;
        };
    }
    
    v.erase(
        remove_if(v.begin(), v.end(), condition), 
        v.end()
    );
}

vector<vector<int>> solution(vector<vector<int>> data, string ext, int val_ext, string sort_by) {
    g_ext = ext;
    valExt = val_ext;
    sortBy = sort_by;
    
    for(auto e: data){
        v.push_back({e[0], e[1], e[2], e[3]});
    }
    
    removeIfLagerThanExt();

    sort(v.begin(), v.end(), compare);
    
    for(auto obj: v){
        answer.push_back({obj.code, obj.date, obj.maximum, obj.remain});
    }
    
    return answer;
}