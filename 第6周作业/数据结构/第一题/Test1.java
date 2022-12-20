package He;

import java.util.HashMap;
import java.util.Stack;

class Stnker {
    public int[] fun(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap();
        Stack<Integer> stack = new Stack();
        int[] res = new int[nums1.length];
        for(int i=nums2.length-1;i>=0;i--){
            while(!stack.isEmpty()&&stack.peek()<nums2[i]){
                stack.pop();
            }
            if(!stack.isEmpty()&&stack.peek()!=null){
                map.put(nums2[i],stack.peek());
            }else{
                map.put(nums2[i],-1);
            }
            stack.push(nums2[i]);
        }
        for(int j=0;j<nums1.length;j++){
            res[j] = map.get(nums1[j]);
        }
        return res;
    }
}
public class Test1 {
    public static void main(String[] args) {
        int nums1[]={4,1,2};
        int nums2[]= {1,3,4,2};
        int[] ints = new Stnker().fun(nums1, nums2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
