class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];
        long startRow=left/n;
        long startColumn=left%n;
        
        long endRow=right/n;
        long endColumn=right%n;
        int idx=0;
        for(long i=left;i<=right;i++){
            int a=(int)(i/n);
            int b=(int)(i%n);
            if(a>=b){
                answer[idx++]=a+1;
            }else{
                answer[idx++]=b+1;
            }
        }
        return answer;
    }
}
