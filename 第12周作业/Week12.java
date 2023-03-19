package SFSJ;

public class Week12 {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k=2;
        System.out.println(fun(nums,k));
    }

    public static int fun(int[] nums, int k) {
        int total = 0;
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i-1] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == k){
                res++;
            }
            for (int j = 0; j < i; j++) {
                if(nums[i] - nums[j] == k){
                    res++;
                }
            }
        }
        return res;
    }
}
