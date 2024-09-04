/**
* A는 오름차순, B는 내림차순으로 정렬해서 곱하기
* [1, 2]      [4, 3]
* -> 1*4 + 2*3 = 4+6 = 10
* 최솟값을 만들 수 있음
*/
import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        //Integer[] Barr = Arrays.stream(B).boxed().toArray(Integer[]::new);
        int[] result = new int[A.length];
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for (int i=0; i<A.length; i++) {
            result[i] += A[i] * B[A.length-i-1];
        }

        return Arrays.stream(result).sum();
    }
}