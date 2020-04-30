//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution2 {
    //    public static void main(String[] args) {
//        ListNode listNode = new ListNode(5);
//        ListNode listNode1 = new ListNode(5);
//        System.out.println(new Solution().addTwoNumbers(listNode,listNode1).next.val);
//    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean isTen = false;
        ListNode firstIndex = null;
        ListNode lastIndex = null;
        for (; l1 != null; l1 = l1.next, l2 = l2.next) {
            int sum;
            sum = l1.val + l2.val;
            if (isTen) {
                sum += 1;
                isTen = false;
            }
            if (sum >= 10) {
                isTen = true;
                sum = sum % 10;
            }

            ListNode listNode = new ListNode(sum);
            if (lastIndex == null) {
                firstIndex = listNode;
                lastIndex = listNode;
            } else {
                lastIndex.next = listNode;
                lastIndex = listNode;
            }
            if (l1.next == null && l2.next != null) {
                l1.next = new ListNode(0);
            }
            if (l1.next != null && l2.next == null) {
                l2.next = new ListNode(0);
            }
            if (l1.next == null && l2.next == null) break;

        }
        if (isTen) {
            ListNode listNode = new ListNode(1);
            lastIndex.next = listNode;
        }
        return firstIndex;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
