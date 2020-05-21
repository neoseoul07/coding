import java.util.*;
import java.util.stream.Collectors;

class Main8 {
    public static void main(String[] args) {
        new BurstBalloons().maxCoins(new int[]{6, 1, 2, 3, 4});
    }
}
class BurstBalloons {
    private int maxCoinsHelper(int[] nums, int start, int end) {
        if (nums.length == 0 || end - start < 0)
            return 0;
        int maxCoins = -1;
        for (int i =start; i <= end; i++) {
            int left = 0;
            int leftEle = 1;
            if (i-1 >= start) {
                left = maxCoinsHelper(nums, start, i-1);
                leftEle = nums[i-1];
            }
            int right = 0;
            int rightEle = 1;
            if (i+1 <= end) {
                right = maxCoinsHelper(nums, i+1, end);
                rightEle = nums[i+1];
            }
            if (leftEle*nums[i]*rightEle + left + right > maxCoins)
                maxCoins = leftEle*nums[i]*rightEle + left + right;
        }
        return maxCoins;
    }

    public int maxCoins(int[] nums) {
        int coins = maxCoinsHelper(nums, 0, nums.length - 1);
        System.out.println(coins);
        return coins;
    }
}
