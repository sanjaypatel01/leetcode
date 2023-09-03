class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return rob(0, nums, dp);
    }
    private int rob(int index, int []nums, int []dp) {
        if(index >= nums.length) return 0;
        if(dp[index] != -1) return dp[index];
        int take = nums[index] + rob(index + 2, nums, dp);
        int notTake = rob(index + 1, nums, dp);
        return dp[index] = Math.max(take, notTake);
    }
}