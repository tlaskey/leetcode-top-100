
public class AddTwoNumbersLeetcode {
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            /*
            (2 -> 4 -> 3) + (5 -> 6 -> 4)
            Output: (7 -> 0 -> 8)
            342 + 465 = 807

            res: ()
            (2 -> 4 -> 3) + (5 -> 6 -> 4)
            (0 -> 2 -> 4 -> 3) + (0 -> 5 -> 6 -> 4)
             i    j               i    j
             2 + 5 = 7
             res: (7)
             (0 -> 0 -> 4 -> 3) + (0 -> 0 -> 6 -> 4)
                   i    j               i    j
             4 + 6 = 10
             res: (7, 0)
             carry over the 1
             (0 -> 0 -> 1 -> 3) + (0 -> 0 -> 1 -> 4)
                        i    j               i    j
             3 + 4 + 1 = 8
             res: (7, 0, 8)
            */

            ListNode head = new ListNode(0);
            ListNode one = l1;
            ListNode two = l2;
            ListNode curr = head;

            int carry = 0;
            while (one != null || two != null) {
            int x = (one != null) ? one.val : 0;
            int y = (two != null) ? two.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;

            curr.next = new ListNode(sum %= 10);
            curr = curr.next;

            if (one != null) one = one.next;
            if (two != null) two = two.next;
            }
            if (carry > 0) curr.next = new ListNode(carry);

            return head.next;
        }
}
