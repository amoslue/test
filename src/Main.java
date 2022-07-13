import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int ret = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[][] dp = new int[arr.length - 1][arr.length];
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int diff = arr[j] - arr[i];
                if (map.containsKey(diff) && map.get(diff) < j) {
                    dp[i][j] = dp[diff][i] + 1;
                    ret = Math.max(ret, dp[i][j] + 2);

                }
            }

        }

        return ret;
    }
}


