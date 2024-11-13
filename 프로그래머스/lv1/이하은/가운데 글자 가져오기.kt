class Solution {
    fun solution(s: String): String {
        val mid = s.length / 2 
        if(s.length % 2 == 0){
            return s.substring(mid - 1, mid + 1)
        }else{
            return s[mid].toString()
        }
    }
}