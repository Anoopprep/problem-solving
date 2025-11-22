/**
 * 143. Reorder List
 * You are given the head of a singly linked-list. The list can be represented as:
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 * 
 * Algorithm:
 * Get the middle
 * Reverse from the middle
 * Alternatively, add the elements from both list
 * Make sure to cut the list at the middle after getting the middle
 */

package List;

public class ReorderList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void reorderListCountApproach(ListNode head) {
        int size = 0;
        ListNode res = new ListNode(Integer.MIN_VALUE), dummy = res;
        ListNode curr = head;

        while(curr != null) {
            curr = curr.next;
            size++;
        }

        int breakAt = (int)Math.ceil(size / 2.0);
        int count = 0;
        curr = head;

        while(count < breakAt - 1) {
            curr = curr.next;
            count++;
        }

        ListNode prev = null, second = curr.next;
        curr.next = null;
        while(second != null) {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        // List1
        curr = head;

        //List 2
        second = prev;
        count = 0;

        while(curr != null || second != null) {
            if(count % 2 == 0) {
                res.next = curr;
                curr = curr.next;
            }
            else {
                res.next = second;
                second = second.next;
            }
            count++;
            res = res.next;
        }

        head = dummy.next;
    }

    public void reorderList(ListNode head) {
        ListNode res = new ListNode(Integer.MIN_VALUE), dummy = res;
        ListNode slow = head, fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null, second = slow.next;
        slow.next = null;
        while(second != null) {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        // List1
        ListNode curr = head;

        //List 2
        second = prev;
        int count = 0;

        while(curr != null || second != null) {
            if(count % 2 == 0) {
                res.next = curr;
                curr = curr.next;
            }
            else {
                res.next = second;
                second = second.next;
            }
            count++;
            res = res.next;
        }

        head = dummy.next;
    }
}
