import java.util.Arrays;

/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author Liliana Dhaliwal
 */

public class MakingChange {
    public static long countWays(int target, int[] coins) {

        Arrays.sort(coins);
        long count = 0;

        long[] currentCounts = new long[target + 1];

        for (int i = 1; i < currentCounts.length; i++){
            currentCounts[i] = findCount(coins, currentCounts, i, 0, 0);
        }

        //System.out.println(Arrays.toString(currentCounts));

        for (int i = 0; i < coins.length; i++){
            count += findCount(coins, currentCounts, target, i, coins[i]);
        }

        return count;
//        return currentCounts[target];
    }

    public static long findCount(int[] coins, long[] currentCounts, int target, int currentCoinIndex, int total){
        if (total > target){
            return 0;
        }
        else if (total == target) {
            return 1;
        }

        long count = 0;

        for (int i = currentCoinIndex; i < coins.length; i++){
            // Wrong spot ?
//            if(currentCounts[target - total] != 0){
//                return currentCounts[target - total];
//            }

            count += findCount(coins, currentCounts, target, i, (total + coins[i]));
        }

        return count;
    }
}
