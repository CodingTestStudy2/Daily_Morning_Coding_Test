#include <string>
#include <vector>

using namespace std;

int dx[4]={1,0,-1,0};
int dy[4]={0,1,0,-1};//동남서북

vector<int> solution(vector<string> park, vector<string> routes) {
    vector<int> answer;
    int x=0;
    int y=0;
    for(int i=0;i<park.size();i++)
    {
        for(int j=0;j<park[i].size();j++)
        {
            if(park[i][j]=='S')
            {
                x=j;
                y=i;
                break;
            }
        }
    }
    int dir=0;
    int flag=0;
    for(int i=0;i<routes.size();i++)
    {

        if(routes[i][0]=='E')
        {
            dir=0;
        }
        else if(routes[i][0]=='S')
        {
            dir=1;
        }
        else if(routes[i][0]=='W')
        {
            dir=2;
        }
        else
        {
            dir=3;
        }
        int temp_x=x;
        int temp_y=y;
        for(int j=0;j<routes[i][2]-'0';j++)
        {
            temp_x+=dx[dir];
            temp_y+=dy[dir];
            if(temp_x>=park[0].size()||temp_x<0||temp_y>=park.size()||temp_y<0)
            {
                flag=1;
                break;
            }
            if(park[temp_y][temp_x]=='X')
            {
                flag=1;
                break;
            }
        }
        
        if(flag==0)
        {
            x=temp_x;
            y=temp_y;
        }
        flag=0;
    }
    answer.push_back(y);
    answer.push_back(x);

    
    
    return answer;
}
