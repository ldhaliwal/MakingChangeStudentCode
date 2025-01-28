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

        long[] coinCount = new long[coins.length];

        for (int i = 0; i < coinCount.length; i++){
            coinCount[i] = findCoinsCount(coins, coins[i], 0, 0);
        }

        //System.out.println(Arrays.toString(coinCount));

        for (int i = 0; i < coins.length; i++){
            count += findCount(coins, coinCount, target, i, coins[i]);
        }

        return count;
    }

    public static long findCount(int[] coins, long[] coinCount, int target, int currentCoinIndex, int total){
        if (total > target){
            return 0;
        }
        else if (total == target) {
            return 1;
        }

        long count = 0;

        for (int i = currentCoinIndex; i < coins.length; i++){
            // I think this placement is wrong
            if(coins[i] == (target - total)){
                return coinCount[i];
            }

            count += findCount(coins, coinCount, target, i, (total + coins[i]));
        }

        return count;
    }

    public static long findCoinsCount(int[] coins, int target, int currentCoinIndex, int total){
        if (total > target){
            return 0;
        }
        else if (total == target) {
            return 1;
        }

        long count = 0;

        for (int i = currentCoinIndex; i < coins.length; i++){
            count += findCoinsCount(coins, target, i, (total + coins[i]));
        }

        return count;
    }
}
