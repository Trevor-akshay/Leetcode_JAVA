import java.io.*;
class Solution {
   public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       int length = scanner.nextInt();
    int[] array = new int[length];
       for(int i = 0 ; i<length ; i++)
           array[i]= scanner.nextInt();
     Solution sol = new Solution();
    int value = sol.removeDuplicates(array);
        System.out.println(value);
    }
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2)
		return nums.length;
 
	int j = 0;
	int i = 1;
 
	while (i < nums.length) {
		if (nums[i] != nums[j]) {
			j++;
			nums[j] = nums[i];
		}
 
                i++;
	}
 
	return j + 1;
    }
}