package He;

import java.util.HashMap;
import java.util.Stack;

class Solution {
    public boolean fun(int[] pushed, int[] popped) {
        int N = pushed.length;
        Stack<Integer> stack = new Stack();
        int j = 0;
        for (int x: pushed) {
            stack.push(x);
            while (!stack.isEmpty() && j < N && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return j == N;
    }}

public class Test2{
    public static void main(String[] args) {
        int nums1[]={1,2,3,4,5};
        int nums2[]= {5,4,3,2,1};
        System.out.println(new Solution().fun(nums1,nums2));
    }
}
