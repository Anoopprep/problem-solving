/**
 * Floyd’s Tortoise and Hare technique.
 * Move slow by one and fast by 2.
 * For even length lists, slow will be in the middle when fast is at last - 1.
 * For odd length lists, slow will be in the middle when fast is at last.
 * If there's a cycle, fast will eventually meet slow(fast chases slow). After every move, the distance between fast and slow
 * decreases by 1
 * Fast enters cycle first and keep on looping the cycle
 * Slow enters cycle later
 * Once both are in the cycle, fast eventually catches slow
 * They meet somewhere inside the cycle
 * Time complexity is o(n)
 * Each iteration moves slow by 1 step and fast by 2 steps,
 * and the fast pointer can catch the slow pointer in at most one full cycle.
 * So total iterations is at most n (to reach cycle) + cycle_length (≤ n).
 * That’s O(n).
*/

package List;

public class LinkedListCycle {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;

        if(head == null) return false;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }
        return false;
    }
}
