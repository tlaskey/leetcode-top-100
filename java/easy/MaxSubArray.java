public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        // https://leetcode.com/problems/maximum-subarray/

        // greedy soln. O(n) time, O(1) space
        int currSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}