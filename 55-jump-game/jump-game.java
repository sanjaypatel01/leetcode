class Solution {
    public boolean canJump(int[] nums) {
        int maxReachable = 0;
        int i=0;
        for(;i <= maxReachable && i < nums.length; i++) {
            maxReachable = Math.max(maxReachable, i + nums[i]);
        }
        return i == nums.length;
    }
}