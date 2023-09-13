class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int []left = new int[n];
        int []right = new int[n];
        //Arrays could have been filled with 1, but filling will take a whole loop.
        //It will be easy, but increase execution time. 
        left[0] = 1;
        for(int i=1; i < n; i++) {
            if(ratings[i] > ratings[i-1]) left[i] = left[i-1] + 1;
            else left[i] = 1;
        }
        right[n-1] = 1;
        for(int i=n-2; i >= 0; i--) {
            if(ratings[i] > ratings[i+1]) right[i] = right[i+1] + 1;
            else right[i] = 1;
        }
        int sum = 0;
        for(int i=0; i < n; i++){
            sum +=Math.max(left[i], right[i]);
        }
        return sum;
    }
}