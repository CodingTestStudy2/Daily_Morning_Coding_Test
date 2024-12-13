/*
val cnt = gdc(w, h)
w*h - ((w/cnt + h/cnt - 1) * cnt)
*/
class Solution {
    fun solution(w: Int, h: Int): Long {
        val cnt = gcd(w, h)
        return w*h.toLong() - ((w/cnt + h/cnt - 1) * cnt.toLong())
    }
    
    fun gcd(a: Int, b: Int): Int {
        if(a % b == 0){
            return b
        }else{
            return gcd(b, a % b)
        }
    }
}