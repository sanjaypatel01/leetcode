class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int total = 0;
        for(int i=cost.length-1; i >= 0; i=i-3) {
            if(i >= 2){
                total = total + cost[i] + cost[i-1];
            } else {
                while(i >= 0){
                    total = total + cost[i];
                    i--;
                }
            }
        }
        return total;
    }
}