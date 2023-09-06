class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int []dp = new int[days.length];
        Arrays.fill(dp, -1);
        
        return mincost(0, days, costs, dp);
    }
    
    private int mincost(int index, int []days, int []costs, int []dp) {
        if(index >= days.length) return 0;
        if(dp[index] != -1) return dp[index];
        
        int dayPassCost = costs[0] +  mincost(index + 1, days, costs, dp);
        int i = index;
        while(i < days.length && (days[index] + 6) >= days[i]) i++;
        int weekPassCost = costs[1] + mincost(i,  days, costs, dp);
        i = index;
        while(i < days.length && (days[index] + 29) >= days[i]) i++;
        int monthPassCost = costs[2] + mincost(i,  days, costs, dp);
        
        return dp[index] = Math.min(Math.min(dayPassCost, weekPassCost), monthPassCost);
    }
}