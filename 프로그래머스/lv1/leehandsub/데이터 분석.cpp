#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

typedef struct NODE{
    int code;
    int date;
    int maximum;
    int remain;
    NODE(int _code,int _date,int _maximum,int _remain)
    {
        code=_code;
        date = _date;
        maximum= _maximum;
        remain = _remain;
    }
}NODE;

bool cmp_date(NODE &a,NODE &b)
{
    return a.date<b.date;
}
bool cmp_code(NODE &a,NODE &b)
{
    return a.code<b.code;
}
bool cmp_maximum(NODE &a,NODE &b)
{
    return a.maximum<b.maximum;
}
bool cmp_remain(NODE &a,NODE &b)
{
    return a.remain<b.remain;
}

vector<vector<int>> trans()
{
}

vector<vector<int>> solution(vector<vector<int>> data, string ext, int val_ext, string sort_by) {
    vector<vector<int>> answer;
    vector<NODE> arr;
    
    for(int i=0;i<data.size();i++)
    {
        arr.push_back(NODE(data[i][0],data[i][1],data[i][2],data[i][3]));
    }
    if(sort_by=="remain")
    {
        sort(arr.begin(),arr.end(),&cmp_remain);
    }
    else if(sort_by=="code")
    {
        sort(arr.begin(),arr.end(),&cmp_code);
    }
    else if(sort_by=="date")
    {
        sort(arr.begin(),arr.end(),&cmp_date);
    }
    else
    {
        sort(arr.begin(),arr.end(),&cmp_maximum);
    }
    if(ext =="remain")
    {
        for(int i=0;i<arr.size();i++)
        {
            if(val_ext>arr[i].remain)
            {
                vector<int> temp;
                temp.push_back(arr[i].code);
                temp.push_back(arr[i].date);
                temp.push_back(arr[i].maximum);
                temp.push_back(arr[i].remain);
                answer.push_back(temp);
            }
        }
    }
    else if(ext =="code")
    {
        for(int i=0;i<arr.size();i++)
        {
            if(val_ext>arr[i].code)
            {
                vector<int> temp;
                temp.push_back(arr[i].code);
                temp.push_back(arr[i].date);
                temp.push_back(arr[i].maximum);
                temp.push_back(arr[i].remain);
                answer.push_back(temp);
            }
        }
    }
    else if(ext =="date")
    {
        for(int i=0;i<arr.size();i++)
        {
            if(val_ext>arr[i].date)
            {
                vector<int> temp;
                temp.push_back(arr[i].code);
                temp.push_back(arr[i].date);
                temp.push_back(arr[i].maximum);
                temp.push_back(arr[i].remain);
                answer.push_back(temp);
            }
        }
    }
    else
    {
        for(int i=0;i<arr.size();i++)
        {
            if(val_ext>arr[i].maximum)
            {
                vector<int> temp;
                temp.push_back(arr[i].code);
                temp.push_back(arr[i].date);
                temp.push_back(arr[i].maximum);
                temp.push_back(arr[i].remain);
                answer.push_back(temp);
            }
        }
    }
    
    
    return answer;
}
