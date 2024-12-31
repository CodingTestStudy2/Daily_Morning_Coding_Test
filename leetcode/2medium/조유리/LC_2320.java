import java.util.Arrays;

class LC_2320 {
    public int countHousePlacements(int n) {
        // 한 street에서 서로 인접하지 않게 위치하는 경우의 수를 구하고, 나머지를 제곱하고 제곱수의 나머지를 구한다.
        long moudlo = 1000000000 + 7;
        long dp[] = new long[n+1];
        dp[0] = 1; dp[1] = 2;
        for(int i=2; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % moudlo;
        }
        System.out.println(Arrays.toString(dp));
        long mod = dp[n] % (moudlo);
        return (int)(mod*mod % moudlo);
    }
}