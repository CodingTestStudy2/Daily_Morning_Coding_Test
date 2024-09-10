import java.util.*;

class Solution {

    public int[] solution(int N,int[] stages) {
        // N은 전체 맵의 개수
        // stages.length는 사용자 수
        // stages[n] 사용자가 현재 멈춰 있는 곳.

        int[] arrN = new int[N]; // 해당 맵에 도달한 사람의 수.
        int[] stayN = new int[N]; // 해당 맵에서 못 벗어난 사람의 수.
        double[] fRate = new double[N]; // 실패율
        int[] answer = new int[N]; //  실패율 순으로 사용자 정렬

        Map map = new HashMap();


        for(int i = 0 ; i < N ; i++){  //삽입정렬?
            arrN[i] = 0;
            stayN[i] = 0;
            for(int j = 0 ; j < stages.length ; j++){
                if(stages[j] >= i+1) arrN[i]++;
                if(stages[j] == i+1) stayN[i]++;
            }
            if(arrN[i] == 0){
                map.put(i,0.0);
                fRate[i] = 0.0;
            }
            else{
                map.put(i,(double)stayN[i] / (double)arrN[i]);
                fRate[i] = (double)stayN[i] / (double)arrN[i];
            }
        }

        Arrays.sort(fRate);
        System.out.println(Arrays.toString(fRate));
        for(int i = fRate.length-1; i >= 0  ; i--)
        {
            for(int j = 0 ; j < map.size() ; j++)
            {
                if(fRate[i] == (double)map.get(j))
                {
                    answer[Math.abs(i-(fRate.length-1))] = j+1;
                    map.replace(j,-1.0);
                    break;
                }
            }
        }
        return answer;
    }
}