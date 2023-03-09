package SFSJ;

import java.util.*;

public class Week11 {

    public static void test(ListNode head){
        ListNode listNode = reverseList(head);
        System.out.println("反转链表第一个值"+listNode.val);
        System.out.println("是否为回⽂链表:"+hasCycle(head));
        test3();

    }
    public static void test3() {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        l1.next=l2;
        l2.next=l3;
        ListNode l10=new ListNode(3);
        ListNode l20=new ListNode(4);
        ListNode l30=new ListNode(5);
        l10.next=l20;
        l20.next=l30;
        ListNode merge = merge(l1, l10);
        System.out.println("输⼊两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的:"+merge.val);
    }
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        l1.next=l2;
        l2.next=l3;
        test(l1);
    }
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode current = reverseList(head.next);
        ListNode temp = head.next;
        temp.next = head;
        head.next = null;
        return current;
    }
    public static boolean hasCycle(ListNode head) {
        if(head==null||head.next==null){
            return false;
        }
        ListNode fast=head,slow=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    public static ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        ListNode root = new ListNode();
        ListNode pointer = root;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                pointer.next = head1;
                head1 = head1.next;
            } else {
                pointer.next = head2;
                head2 = head2.next;
            }

            pointer = pointer.next;
        }
        if (head1 != null) {
            pointer.next = head1;
        }
        if (head2 != null) {
            pointer.next = head2;
        }
        return root.next;
    }

}
class ListNode {
    int val; //链表中节点的值
    ListNode next; //引用
    public ListNode() {}
    public ListNode(int val) {
        this.val = val;
    }
}
/*⽐如你想创建⼀个链表： 1->2->3
就可以写成如下格式：
ListNode l1=new ListNode(1);
ListNode l2=new ListNode(2);
ListNode l3=new ListNode(3);
l1.next=l2;
l2.next=l3;
*/