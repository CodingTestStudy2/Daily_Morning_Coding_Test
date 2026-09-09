/* 

1. 아이디어 : 조건에 맞게 체크

2. 시간복잡도 : O(9)

3. 자료구조/알고리즘 : 조건문

 */

class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {  

     int BULKY_VOLUME = 1000000000;
     int BULKY_LEN = 10000;
     int HEAVY = 100;

     boolean isHeavy = false;
     boolean isBulky = false;

     if(mass >= HEAVY) isHeavy = true;
    
     if(length >= BULKY_LEN) isBulky = true;
     else if(width >= BULKY_LEN) isBulky = true;
     else if(height >= BULKY_LEN) isBulky = true;
     else if((long)width*height*length>=BULKY_VOLUME) isBulky = true;

     if(isBulky && isHeavy) return "Both";
     else if(!isBulky && !isHeavy) return "Neither";

     if(isBulky) return "Bulky";
     
     return "Heavy";

    }
}