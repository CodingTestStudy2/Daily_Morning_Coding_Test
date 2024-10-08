
import java.util.*
import kotlin.math.*
typealias PII = Pair<Int, Int>
    
/*
0은 비어 있음, 1은 벽
인접한 두 빈칸을 상하/좌우 연결 -> 직선 도로 100
두 직선 도로가 직각으로 만나는 지점 -> 코너 500
경주로를 건설하는데 필요한 최소 비용 (0, 0) ~ (n-1, n-1)
*/
class Solution {
    lateinit var graph: Array<IntArray>
    
    // 상하, 좌우 방향에 따른 최소 비용 테이블 
    lateinit var dp: Array<Array<Array<Int>>> 
    
    // 최소 비용 테이블의 초기값 
    val INF = 1e9.toInt() 
    
    val dx = listOf(-1, 0, 1, 0)
    val dy = listOf(0, -1, 0, 1)
    var N = 0
    
    data class Car(
        val pos: PII,
        val cost: Int,
        val dir: Int // 상하: 0, 좌우: 1
    )

    fun solution(board: Array<IntArray>): Int {
        N = board.size
        graph = board
        
        // 최소 비용 테이블 초기화 
        dp = Array(N) { Array(N) { arrayOf(INF, INF) } }
        dp[0][0][0] = 0
        dp[0][0][1] = 0
        
        // 상하 또는 좌우 방향 중에 최소 비용으로 리턴 
        return bfs()
    }
    
    fun bfs(): Int {
        val q = ArrayDeque<Car>()
        
        // 아래로 이동 가능한 경우 
        if(graph[1][0] == 0){
            dp[1][0][0] = 100
            
            q.offer(Car(
                pos = Pair(1, 0),
                cost = 100, 
                dir = 0
            ))
        }
        
        // 오른쪽으로 이동 가능한 경우 
        if(graph[0][1] == 0){ 
            dp[0][1][1] = 100
            
            q.offer(Car(
                pos = Pair(0, 1),
                cost = 100, 
                dir = 1
            ))
        }
        
        // BFS 탐색 진행 
        while(!q.isEmpty()){
            val front = q.poll()
            val x = front.pos.first
            val y = front.pos.second
            
            // 상하좌우 탐색 
            for(i in 0..3){
                val nx = x + dx[i]
                val ny = y + dy[i]
                var cost = front.cost
                var dir = front.dir
                
                // 이동 불가능하면 패스 
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue 
                if(graph[nx][ny] == 1) continue 
                
                // 0 또는 1의 방향이 
                // 이전과 동일한 경우, 직선 도로 
                if(i % 2 == dir){
                    cost += 100 
                }else{
                    cost += 600
                    dir = (dir + 1) % 2 // 코너는 방향 갱신 
                }
                
                // 이미 최소 비용이 저장된 경우 패스 
                if(dp[nx][ny][dir] < cost) continue 
                
                // 최소 비용 테이블 갱신 
                dp[nx][ny][dir] = cost 
                q.offer(Car(
                    pos = Pair(nx, ny),
                    cost = cost, 
                    dir = dir 
                ))
            }
        }
        
        return min(dp[N - 1][N - 1][0], dp[N - 1][N - 1][1])
    }
}