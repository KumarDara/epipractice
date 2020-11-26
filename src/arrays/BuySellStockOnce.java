package arrays;

public class BuySellStockOnce {
    public static int getMaxProfit(int[] stocks) {
        int maxProfit = 0; int minSoFar = Integer.MAX_VALUE;
        for(int stock: stocks) {
            maxProfit = Math.max(maxProfit, stock - minSoFar);
            minSoFar = Math.min(minSoFar, stock);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(getMaxProfit(new int[] {310,315, 275, 295, 260, 270, 290, 230, 255, 250}));
    }
}
