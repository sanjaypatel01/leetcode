/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        
        int index = findPeakIndex(mountainArr);
        int resultantIndex = binarySearch(mountainArr, 0, index, target, true);
        if(resultantIndex != -1) return resultantIndex;

        return binarySearch(mountainArr, index+1, mountainArr.length()-1, target, false);
    }

    private int binarySearch(MountainArray mountainArr, int start, int end , int target, boolean isIncreasing) {

        while(start <= end) {
            int mid = start + (end - start)/2;
            if(mountainArr.get(mid) == target) return mid;
            else if ((isIncreasing && mountainArr.get(mid) < target) || 
                (!isIncreasing && mountainArr.get(mid) > target)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }


    private int findPeakIndex(MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length() - 1;
        int index = 0;
        int max = mountainArr.get(0);
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(mid < end && mountainArr.get(mid) <= mountainArr.get(mid + 1)) {
                if(max <= mountainArr.get(mid + 1)) {
                    index = mid + 1;
                    max = mountainArr.get(mid + 1);
                } 
                start = mid + 1;
            } else {
                if(max <= mountainArr.get(mid)) {
                    index = mid;
                    max = mountainArr.get(mid);
                } 

                end = mid - 1; 
            }
            //System.out.println("Index :: "+index + " ,Start ::"+start + " ,Mid:: "+mid+" ,End::"+end + " ,Max::"+max);
        }
        return index;
    }

    
}