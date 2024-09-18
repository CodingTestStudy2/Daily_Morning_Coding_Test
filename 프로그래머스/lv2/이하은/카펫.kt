/**
1 2 3 4 
5 6 7 8
9 10 11 12

brown = 2 * w + 2 * (h - 2) = 10
yellow = (w * h) - brown = 2

w + h = (brown / 2) + 2 = 7
w * h = yellow + brown = 12
w >= h (최소 3)

*/
class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        var h = 3
        var w = (brown / 2) + 2 - h
        
        while(w * h != yellow + brown){
            w--
            h++
        }
        
        return intArrayOf(w, h)
    }
}