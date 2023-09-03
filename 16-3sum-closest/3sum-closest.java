class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        for(int i=0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = n-1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int cDiff = target - sum;
                if(Math.abs(diff) > Math.abs(cDiff)) {
                    ans = sum;
                    diff = cDiff;
                }
                if(sum > target) k--;
                else j++;
            }
        }
        return ans;
    }
}