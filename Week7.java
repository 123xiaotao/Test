package SFSJ;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
public class Week7 {
    static Random random=new Random();
    public static void test(){
        System.out.println(task1("abbc","dog cat cat fish"));
        System.out.println(task2(new int[]{1,2,2,3,0}));
        for(int i=0;i<5;i++){
            int target = random.nextInt(15) - 3;
        System.out.println("target:"+target+"\tresult"+task3(new int[]
                    {0,4,5,6,8},target));
        }
    }
    public static void main(String[] args) {
        test();
    }
    public static boolean task1(String pattern, String str) {
//第一题代码
        boolean res=true;
        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        Map<Object, Integer> map = new HashMap<>();
        for (Integer i = 0; i < words.length; i++) {
            if (map.put(pattern.charAt(i), i) != map.put(words[i], i)) {
                return false;
            }
        }
        return res;
    }
    public static int task2(int[] nums) {
//第二题代码
        int n = nums.length ;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++){
                if(nums[i]== nums[j])
                    return nums[i];
            }
        }
        return 0;
    }
    public static int task3(int []nums,int target){
//第三题代码
        int left = 0,right = nums.length-1;
        int mid=0;
        while(left <= right){
             mid = (left + right)/2;
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return -mid-1;
    }
}
