package Leetcode.김도연;

import java.util.TreeSet;

public class Q3479 {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;

        TreeSet<Integer> availableIndices = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            availableIndices.add(i);
        }

        int unplaced = 0;

        for (int i = 0; i < n; i++) {
            boolean placed = false;
            for (int j : availableIndices) {
                if (baskets[j] >= fruits[i]) {
                    availableIndices.remove(j);
                    placed = true;
                    break;
                }
            }

            if (!placed) unplaced++;
        }

        return unplaced;
    }
}

