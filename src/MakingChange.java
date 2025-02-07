import java.util.Arrays;

/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author Liliana Dhaliwal
 */

public class MakingChange {
    public static long[][] counts;

    public static long countWays(int target, int[] coins) {

        // tabulation!
        long[][] counts = new long[coins.length][target + 1];

        for (int i = 0; i < coins.length; i++){
            counts[i][0] = 1;
        }

        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= target; j++) {

                if ((j - coins[i]) >= 0) {
                    counts[i][j] += counts[i][j - coins[i]];
                }

                if ((i - 1) >= 0) {
                    counts[i][j] += counts[i - 1][j];
                }
            }
        }
        return counts[coins.length - 1][target];

//         Un-comment for memoization:
//        Arrays.sort(coins);
//        counts = new long[coins.length][target + 1];
//
//        return count(target, 0, coins);
    }

    public static long count(int target, int index, int[] coins) {
        if (target < 0 || index >= coins.length) {
            return 0;
        } else if (counts[index][target] != 0) {
            return counts[index][target];
        } else if (target == 0) {
            return 1;
        }

        counts[index][target] = count(target - coins[index], index, coins) + count(target, index + 1, coins);

        return counts[index][target];
    }
}
