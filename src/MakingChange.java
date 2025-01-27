import java.util.ArrayList;
import java.util.Arrays;

/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author Liliana Dhaliwal
 */

public class MakingChange {
    /**
     * TODO: Complete this function, countWays(), to return the number of ways to make change
     *  for any given total with any given set of coins.
     */
    public static long countWays(int target, int[] coins) {

        Arrays.sort(coins);
        long count = 0;

        // need to be able to find and store the number of ways to make each COIN with the set of coins we have.
        // then add that into recursive method somehow.

        for (int i = 0; i < coins.length; i++){
            count += findCount(coins, target, i, coins[i]);
        }

        return count;
    }

    public static long findCount(int[] coins, int target, int currentCoinIndex, int total){
        if (total > target){
            return 0;
        }
        else if (total == target) {
            return 1;
        }

        int count = 0;
        for (int i = currentCoinIndex; i < coins.length; i++){
            count += findCount(coins, target, i, (total + coins[i]));
        }

        return count;
    }

}
