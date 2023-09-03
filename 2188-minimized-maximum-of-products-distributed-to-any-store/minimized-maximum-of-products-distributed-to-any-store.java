class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int max = 0;
        //long sum = 0;
        for(int q : quantities) {
            max = Math.max(max, q);
            //sum +=q;
        }
        //if(sum < n) return -1;
        int start = 0;
        int end = max;
        int minQuantity = max;
        while(start <= end) {
            int mid = start + (end - start)/2;
            int storeCount = getStores(mid, quantities);
            if(storeCount <= n) {
                minQuantity = Math.min(mid, minQuantity);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return minQuantity <= 0 ? 1 : minQuantity;
    }

    private int getStores(int current, int []quantities) {
        int stores = 0;
        for(int q : quantities) {
            stores = stores + (int)Math.ceil((q * 1.0)/current);
        }
        return stores;
    }
}