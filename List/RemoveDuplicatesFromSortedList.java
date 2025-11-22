/**
 * 83. Remove Duplicates from Sorted List
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. 
 * Return the linked list sorted as well.
 * Input: head = [1,1,2], Output: [1,2]
 * Input: head = [1,1,2,3,3], Output: [1,2,3]
 * 
 * Algorithm:
 * Compare prev and curr
 * if same, remove the curr
 * let prev be the same node
 * Make curr next to curr
 * Edge case: Duplicate node to be removed is the last node, in this case next node is null
 */

package List;

public class RemoveDuplicatesFromSortedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode prev = head, curr = head.next;

        while(curr != null) {
            if(prev.val == curr.val) {
                prev.next = curr.next;
                if (prev != null) curr = prev.next;
                else curr = null;
            }
            else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}
