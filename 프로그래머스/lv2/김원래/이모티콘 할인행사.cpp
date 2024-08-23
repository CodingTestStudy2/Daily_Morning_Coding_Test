#include <string>
#include <vector>

using namespace std;

int emoticonPrices[10][10]; // (emoticon종류, 할인 %)
int sales[4] = {10, 20, 30, 40};
int g_Size;
vector<int> answer = {0, 0};
vector<vector<int>> g_users;

void DFS(vector<int>& curEmoticonSales, int curSale)
{
    curEmoticonSales.push_back(curSale);
    
    if(curEmoticonSales.size() - 1 == g_Size)
    {
        int curEarning = 0;
        int curService = 0;
        
        for(int userCnt = 0 ; userCnt < g_users.size() ; ++userCnt)
        {
            int curUserSales = g_users[userCnt][0];
            int curUserMoney = g_users[userCnt][1];
            
            int totalPrice = 0;
            for(int emoticon = 0 ; emoticon < curEmoticonSales.size() ; ++emoticon)
            {
                if(curUserSales <= sales[curEmoticonSales[emoticon]])
                    totalPrice += emoticonPrices[emoticon][curEmoticonSales[emoticon]];
            }
            
            if(curUserMoney <= totalPrice) curService++;
            else curEarning += totalPrice;
        }
        
        if(answer[0] < curService)
            answer = {curService, curEarning};   
        else if(answer[0] == curService)
            answer[1] = max(answer[1], curEarning);
        
        return;
    }
    
    for(int saleCnt = 0 ; saleCnt < 4 ; ++saleCnt)
    {
        DFS(curEmoticonSales, saleCnt);
        curEmoticonSales.pop_back();
    }
    
}


vector<int> solution(vector<vector<int>> users, vector<int> emoticons) {
    g_users = users;
    g_Size = emoticons.size();
    
    for(int cnt = 0 ; cnt < emoticons.size() ; ++cnt)
    {
        int price = emoticons[cnt];
        for(int salesIdx = 0 ; salesIdx < 4 ; ++salesIdx)
            emoticonPrices[cnt][salesIdx] = (price / 100.0) * (100 - sales[salesIdx]);
    }
    
    vector<int> v;
    
    for(int cnt = 0 ; cnt < 4 ; ++cnt)
    {
        v.clear();
        DFS(v, cnt);
    }
    
    return answer;
}