import java.io.IOException;

/**
 * Created by yaswanth on 12/04/19.
 */
class Main3 {
    public static void main(String[] args) throws IOException {
        System.out.println(new BestTimeToBuySellStock().maxProfit(3, new int[]{ 1, 3, 1, 100}));
    }
}

class BestTimeToBuySellStock {
    public int maxProfit(int k, int[] prices) {
        int [][]maxProfitArray = new int[prices.length][k];
        return maxProfitRecc(k, prices, 0, maxProfitArray);
    }

    public int maxProfitRecc(int k, int[] prices, int startIndex, int [][]maxProfitArray) {
        if (k == 0 || prices.length == 0 || startIndex >= prices.length)
            return 0;
        if (maxProfitArray[startIndex][k-1] > 0)
            return maxProfitArray[startIndex][k-1];
        int min = prices[startIndex];
        int i = startIndex;
        i++;
        int maxDiff = 0;
        while(i < prices.length) {
            if (prices[i] <= min)
                min = prices[i];
            else {
                int temp = maxProfitRecc(k-1, prices, i+1, maxProfitArray);
                if (prices[i] - min + temp > maxDiff)
                    maxDiff = prices[i] - min + temp;
            }
            i++;
        }
        maxProfitArray[startIndex][k-1] = maxDiff;
        return maxDiff;
    }
}
