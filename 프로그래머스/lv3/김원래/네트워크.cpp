#include <string>
#include <vector>

using namespace std;

int nodes[200];
int visit[200];

int Find(int i)
{
    if(nodes[i] == i) return i;
    
    return nodes[i] = Find(nodes[i]);
}

void Union(int i, int j)
{
    if(i==j) return;
    
    int iParent = Find(i);
    int jParent = Find(j);
    
    if(iParent < jParent)
    {
        nodes[jParent] = Find(iParent);
    }
    else
    {
        nodes[iParent] = Find(jParent);
    }
}



int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    
    for(int cnt = 0 ; cnt < n ; ++cnt)
    {
        nodes[cnt] = cnt;
    }
    
    for(int i = 0 ; i < n ; ++i)
    {
        for(int j = 0 ; j < n ; ++j)
        {
            if(computers[i][j] == 1)
            {
                Union(i,j);
            }
        }
    }
    
    for(int cnt = 0 ; cnt < n ; ++cnt)
    {
        if(visit[Find(cnt)] == 0)
        {
            ++answer;
            visit[Find(cnt)] = 1;
        }
        
        printf("%d / %d\n", cnt,Find(cnt));
    }
    
    return answer;
}

/*


A - B - C

*/