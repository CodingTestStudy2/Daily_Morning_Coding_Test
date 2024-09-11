class Solution {
    val MAX = 100001
    var N = 0
    var M = 0
    
    val painted = BooleanArray(MAX) {true}
    var ans = Int.MAX_VALUE
    val temp = mutableListOf<Int>()
    
    fun solution(n: Int, m: Int, section: IntArray): Int {
        N = n
        M = m
        
        for(i in section){
            painted[i] = false
        }
        
        dfs(start = 1, cnt = 0)
        
        return ans
    }
    
    fun isAllPainted() = painted.all { it == true }
    
    fun dfs(start: Int, cnt: Int){        
        if(isAllPainted()){
            ans = minOf(ans, cnt)
            return
        }
        
        if(start > N - M + 1){
            if(isAllPainted()){
                ans = minOf(ans, cnt)
            }
            return
        }
        
        for(i in start until N - M + 2){
            if(!painted[i]){
                for(j in i until i + M){
                    if(!painted[j]) {
                        painted[j] = true
                        temp.add(j)
                    }
                }
                
                dfs(i + 1, cnt + 1)
                
                for(idx in temp){
                    painted[idx] = false
                }
                temp.clear()
            }
        }
    }
}