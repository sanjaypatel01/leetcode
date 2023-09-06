class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        if(n == 0) return true;
        if(n >= 2 && stones[1] != 1) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i < n; i++){
            map.put(stones[i], i);
        }

        int [][]dp = new int[2001][2001];
        for(int []arr : dp) Arrays.fill(arr, -1);
        
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