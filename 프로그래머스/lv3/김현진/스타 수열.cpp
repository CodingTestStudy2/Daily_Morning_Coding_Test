//풀이 및 인터넷 참고해서 해결
//시간 초과 없애기 위해 조건문으로 한 번 거르기
//for문에서 j++로 1번, 2번 건너뛰는 거 체크 

#include <string>
#include <vector>

using namespace std;

int solution(std::vector<int> a) {
    int answer = 0;
    vector<int> vec;
    vec.resize(a.size(),0);
    for(auto num : a)
    {
        vec[num] ++;
    }
    for(int i=0;i<vec.size();i++)
    {
        int cnt = 0;
        if(vec[i]<= answer) continue; //시간초과 줄이기 위해 한 번 더 거름 
        else
        {
            for(int j=0;j<a.size()-1;j++)
            {
                if((a[j]==i||a[j+1]==i)&& a[j] != a[j+1])
                {
                    cnt++;
                    j++; //!!
                }
            }
        }
        answer = max(answer , cnt);
    }
    return answer*2;
}
