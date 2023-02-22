package SFSJ;

import java.util.*;

public class Week9 {
    static Random random=new Random();
    public static void printArr(int[]nums){
        System.out.println(Arrays.toString(nums));
    }
    public static void test(){
        int[]nums1=new int[random.nextInt(20)+1];
        for(int i=0;i<nums1.length;i++)
            nums1[i]=random.nextInt(30)-10;
        printArr(nums1);
        printArr(task1(nums1,nums1));
        System.out.println("======================");
        int[]nums2=new int[random.nextInt(20)+1];
        for(int i=0;i<nums2.length;i++)
            nums2[i]=random.nextInt(3);
        printArr(nums2);
        task2(nums2);
        printArr(nums2);
    }
    public static void main(String[] args) {
        test();
    }
    public static int[] task1(int[] nums1, int[] nums2) {
//第一题代码
        int m = nums1.length, n = nums2.length;
        int[] res = new int[m];
        for (int i = 0; i < m; ++i) {
            int j = 0;
            while (j < n && nums2[j] != nums1[i]) {
                ++j;
            }
            int k = j + 1;
            while (k < n && nums2[k] < nums2[j]) {
                ++k;
            }
            res[i] = k < n ? nums2[k] : -1;
        }
        return res;


    }
    public static void task2(int[] nums) {
//第二题代码
        int left,right;
        int i = 0;
        left = 0;
        right = nums.length;
        while(i < right){
            if(nums[i] == 0){
                nums[i] = nums[left];
                nums[left] = 0;
                left++;
                i++;
            }else if(nums[i] == 1){
                i++;
            }else{
                nums[i] = nums[right-1];
                nums[right-1] = 2;
                right--;
            }
        }

    }
}