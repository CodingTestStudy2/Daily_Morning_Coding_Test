#include <string>
#include <vector>

using namespace std;

int lastHouse;
vector<int> curDeliveries;
vector<int> curPickups;
long long answer;

int totalDelivery;

void Solve(int cap)
{
    //while(lastHouse != 0)
    //{
        answer += (lastHouse + 1) * 2;
    
        int curDelivery;
        int curPickup = 0;

        if(totalDelivery > cap) curDelivery = cap;
        else curDelivery = totalDelivery;
    
        totalDelivery -= curDelivery;
    
        while(curPickup != cap && curDelivery != 0)
        {
            if(curDelivery >= curDeliveries[lastHouse])
            {
                curDelivery -= curDeliveries[lastHouse];
                curDeliveries[lastHouse] = 0;
            }
            else
            {   
                curDeliveries[lastHouse] -= curDelivery;
                curDelivery = 0;
            }
        
            if(curPickup + curPickups[lastHouse] <= cap)
            {
                curPickup += curPickups[lastHouse];
                curPickups[lastHouse] = 0;
            }
            else
            {
                int leaveSize = cap - curPickup;
                curPickups[lastHouse] -= leaveSize;
                curPickup = cap;
            }
        
            if(curDeliveries[lastHouse] == 0 && curPickups[lastHouse] == 0) lastHouse--;
        }
    //}
    
    printf("lastHouse : %d\n", lastHouse);
}

long long solution(int cap, int n, vector<int> deliveries, vector<int> pickups) {
   
    lastHouse = n - 1;
    curDeliveries = deliveries;
    curPickups = pickups;
    
    for(int cnt = 0 ; cnt < deliveries.size() ; ++cnt)
    {
        totalDelivery += deliveries[cnt];
    }
    
    Solve(cap);
    Solve(cap);
    Solve(cap);
    
    return answer;
}