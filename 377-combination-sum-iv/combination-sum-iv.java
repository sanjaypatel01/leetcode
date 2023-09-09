class Solution {
    public int combinationSum4(int[] nums, int target) {
        int []dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return comb(nums, target, dp);
    }

    private int comb(int []nums, int sum, int []dp) {
        if(sum == 0) return 1;
        if(sum < 0) return 0;

        if(dp[sum] != -1) return dp[sum];
        int res = 0;
        for(int i=0; i < nums.length; i++) {
            res = res + comb(nums, sum - nums[i], dp);
        }

        return dp[sum] = res;
    }
}