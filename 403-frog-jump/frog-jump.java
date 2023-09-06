class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        // Extra conditions but not really required as input length will not be less than 2.
       if(n == 0) return true;
       if(n >= 2 && stones[1] != 1) return false; // Even this is not required, later execution of code will handle it.
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i < n; i++){
            map.put(stones[i], i);
        }
        // Consider assigning with max value of n and prev 
        int [][]dp = new int[2001][2001];
        for(int []arr : dp) Arrays.fill(arr, -1);
        
        //For first stone, considering 0 as prev jump, so that it can jump 1 only as 0-1, 0-0 are not allowed.
        return canCross(0, stones, 0, map, dp);
    }
    
    private boolean canCross(int index, int []stones, int prev, Map<Integer, Integer> map, int [][]dp) {
        if(index == stones.length-1) {
            return true;
        }
        if(index >= stones.length) return true;
        
        if(dp[index][prev] != -1) return dp[index][prev] == 1 ? true : false;
        
        boolean isCrossed =false;
        if(prev-1 >= 1 && map.containsKey(stones[index] + prev -1)) {
            isCrossed = isCrossed || canCross(map.get(stones[index] + prev - 1), stones, prev - 1, map, dp);
        }
        if(prev >= 1 && map.containsKey(stones[index] + prev)) {
            isCrossed = isCrossed ||  canCross(map.get(stones[index] + prev), stones, prev, map, dp);
        }
        
        if(prev + 1 >= 1 && map.containsKey(stones[index] + prev + 1)) {
            isCrossed = isCrossed || canCross(map.get(stones[index] + prev + 1), stones, prev + 1, map, dp);
        }
        dp[index][prev] = isCrossed ? 1 : 0;
        return isCrossed;
    }
}