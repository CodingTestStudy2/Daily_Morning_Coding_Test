import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        // 나가는 지점을 기준으로 오름차순 정렬 
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        
        // 가장 처음에 나가는 차량부터 카메라 설치 
        int lastPos = routes[0][1];
        int answer = 1;
        
        for (int i = 1; i < routes.length; i++) {
            if (routes[i][0] > lastPos) {
                answer++;
                
                // 마지막으로 카메라를 설치한 지점 갱신 
                lastPos = routes[i][1];
            }
        }
        
        return answer;
    }
}