public class ProductArrayExceptSelf {
    /*
    * https://leetcode.com/problems/product-of-array-except-self/
    * */
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        /*
        Create two arrays, left and right
        left[i] is the product of all nums to left of i
        right[i] is product of all nums to right of i

        input: [1, 2, 3, 4]

        left: [1, 1, 2, 6]
        right: [24, 12, 4, 1]
        result[i] = left[i] * right[i]
        result: [24, 12, 8, 6]
        */

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) left[i] = 1;
            else left[i] = nums[i - 1] * left[i - 1];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) right[i] = 1;
            else right[i] = nums[i + 1] * right[i + 1];
        }

        for (int i = 0; i < output.length; i++) {
            output[i] = left[i] * right[i];
        }

        return output;
    }
}
