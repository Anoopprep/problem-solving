/**
 * 142. Linked List Cycle II
 * Return the node where the cycle begins.
 * 
 * Algorithm:
 * After slow meets fast, reset one of the pointer to head.
 * Now move slow and fast by 1 until they meet. 
 * They meet exactly at the node where cycle begins.
 */

package List;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode detectCycleSetApproach(ListNode head) {
        Set<ListNode> s = new HashSet<ListNode>();
        while(head != null) {
            if(s.contains(head)) return head;
            else s.add(head);
            head = head.next;
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode slow = head, fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                fast = head;

                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }
        return null;
    }
}
