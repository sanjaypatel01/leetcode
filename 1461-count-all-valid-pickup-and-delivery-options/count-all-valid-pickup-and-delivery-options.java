class Solution {
    public int countOrders(int n) {
        long ans = 1;
        int slots = 2 * n;
        while(slots > 0) {
            ans = (ans * (slots * (slots - 1)/2))% ((int)Math.pow(10, 9) + 7);
            slots = slots - 2;
        }
        return (int)ans;
    }
}