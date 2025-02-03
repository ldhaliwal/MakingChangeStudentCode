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

        Arrays.sort(coins);
        counts = new long[coins.length][target + 1];

        return count(target, 0, coins);
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
