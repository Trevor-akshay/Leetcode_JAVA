/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray m) {
        int low = 0;
        int high = m.length()-1;
        
        int index = find(m,low,high);
        int left = search(m,low,index,target,true);
        if(left == -1)
            return search(m,index,high,target,false);
        return left;
    }

    private int find(MountainArray m,int l,int h){
        while (l < h){
            int mid = (l + h) >> 1;
            int value = m.get(mid);
            if(value > m.get(mid + 1) && value > m.get(mid-1))
                return mid;
            else if(value > m.get(mid - 1))
                l = mid;
            else
                h = mid;
        }
        return -1;
    }

    private int search(MountainArray m,int left,int right,int x,boolean isLeft){
        while (left <= right){
            int mid = (left + right) >> 1;
            int value = m.get(mid);
            if(value == x)
                return mid;
            else if(value > x) {
                if(isLeft)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            else {
                if(isLeft)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }
}
