class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int percent5 = arr.length/20;
        double sum = 0.0;
        int cnt = 0;
        for(int i = 0+percent5; i < arr.length - percent5; i++){
            sum += arr[i];
            cnt++;
        }
        return sum/cnt;
    }
}
