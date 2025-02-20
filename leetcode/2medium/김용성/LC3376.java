import java.util.Collections;
import java.util.List;

public class LC3376 {
    public int findMinimumTime(List<Integer> strength, int k) {
        Collections.sort(strength);
        int brokenLocks = 0;

        int mask = 0;
        return bf(strength, mask, 1, k,0);
    }

    private int bf(List<Integer> strength, int mask, int weight, int k, int ret) {
        if (mask == (1 << strength.size()) - 1) return ret;

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < strength.size(); i++) {
            if ((mask & (1 << i)) != 0) continue;
            int count = (strength.get(i) + weight - 1) / weight;
            ans = Math.min(ans,bf(strength, mask | (1<<i), weight + k, k, ret + count));
        }
        return ans;
    }
}
