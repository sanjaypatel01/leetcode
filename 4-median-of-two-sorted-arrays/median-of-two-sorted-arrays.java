class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int start = 0;
        int end = m;
        while(start <= end) {
            int partitionA = start + (end - start)/2;
            int partitionB = (m + n + 1)/2 - partitionA;

            int maxLeftA = partitionA == 0 ? Integer.MIN_VALUE : nums1[partitionA - 1];
            int maxLeftB = partitionB == 0 ? Integer.MIN_VALUE : nums2[partitionB - 1];
            int minRightA = partitionA == m ? Integer.MAX_VALUE : nums1[partitionA];
            int minRightB = partitionB == n ? Integer.MAX_VALUE : nums2[partitionB];

            if((maxLeftA <= minRightB) && (maxLeftB <= minRightA)) {
                if((m + n) % 2 == 0) {
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) /2.0;
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            } else if(maxLeftA > minRightB) {
                end = partitionA -1;
            } else {
                start = partitionA + 1;
            }
        }
        return -1;
    }
}